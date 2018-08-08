package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePassworTest extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        app.changePassword().login("administrator","root");
        app.changePassword().goToUserManagePage();
        app.changePassword().selectUser();
        String userName = app.changePassword().getSelectedUserName();
        String userEmail = app.changePassword().getSelectedUserEmail();
        app.changePassword().refreshPassword();
        long now = System.currentTimeMillis();
        String newPassword = String.format("password %s", now);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, userEmail);
        app.registration().finish(confirmationLink, newPassword);
        HttpSession session = app.newSession();
        assertTrue(session.login(userName, newPassword));
        assertTrue(session.isLoggedInAs(userName));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }



    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}