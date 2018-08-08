package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.io.IOException;

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
}