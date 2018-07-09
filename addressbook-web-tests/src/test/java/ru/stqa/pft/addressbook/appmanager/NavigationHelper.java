package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }



    public void gotoHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.xpath("//div[@id='nav']//a[.='home']"));
    }

    public void returnToHomePage() {

        click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }
}
