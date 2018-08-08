package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class ChangePasswordHelper extends HelperBase{

    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void loginByAdmin(String username, String password) throws IOException {
        type(By.xpath("//input[@name='username']"), username);
        click(By.xpath("//input[@value='Войти']"));
        type(By.xpath("//input[@name='password']"), password);
        click(By.xpath("//input[@value='Войти']"));
    }

    public void goToUserManagePage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void selectUser() {
        List<WebElement> users = wd.findElements(By.xpath("//table//tbody//tr"));
        click(By.xpath("//tbody//tr["+(users.size()-1)+"]//a"));
    }

    public void refreshPassword() {
        wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
    }
}