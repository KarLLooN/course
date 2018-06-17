package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final AbonentHelper abonentHelper = new AbonentHelper();

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        abonentHelper.groupHalper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        abonentHelper.groupHalper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        abonentHelper.groupHalper.wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        abonentHelper.groupHalper.wd.findElement(By.name("user")).click();
        abonentHelper.groupHalper.wd.findElement(By.name("user")).clear();
        abonentHelper.groupHalper.wd.findElement(By.name("user")).sendKeys(username);
        abonentHelper.groupHalper.wd.findElement(By.name("pass")).click();
        abonentHelper.groupHalper.wd.findElement(By.name("pass")).clear();
        abonentHelper.groupHalper.wd.findElement(By.name("pass")).sendKeys(password);
        abonentHelper.groupHalper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        abonentHelper.groupHalper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        abonentHelper.groupHalper.wd.quit();
    }

    public void gotoAddNew() {
        abonentHelper.groupHalper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHalper getGroupHalper() {
        return abonentHelper.groupHalper;
    }

    public AbonentHelper getAbonentHelper() {
        return abonentHelper;
    }
}