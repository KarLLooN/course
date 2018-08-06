package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.io.IOException;

public class ChangePasswordHelper extends HelperBase{

    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) throws IOException {
        app.newSession().login("administrator","root");
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
//        type(By.name("username"), username);
//        type(By.name("email"),email);
//        click(By.cssSelector("input[value='Зарегистрироваться']"));
    }
}