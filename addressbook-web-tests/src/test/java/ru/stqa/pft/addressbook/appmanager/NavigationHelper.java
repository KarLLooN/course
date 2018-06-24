package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoAddNew() {
        click(By.linkText("add new"));
    }

    public void gotoHome(){
        click(By.linkText("home page"));
    }

    public void returnToHomePage(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void closeAlert(){
        wd.switchTo().alert().accept();
    }
}
