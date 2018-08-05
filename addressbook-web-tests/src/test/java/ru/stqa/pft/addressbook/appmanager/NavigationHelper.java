package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }


    public void home() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.xpath("//div[@id='nav']//a[.='home']"));
    }


    public void closeAlert() {
        wd.switchTo().alert().accept();
    }

    public void changeGroupForAdd(String groupName) {
        WebElement element = wd.findElement(By.xpath("//select[@name='to_group']"));
        element.findElement(By.xpath(".//*[text()='" + groupName + "']")).click();
    }

    public void changeGroupForView(String groupName) {
        WebElement element = wd.findElement(By.xpath("//select[@name='group']"));
        element.findElement(By.xpath(".//*[text()='" + groupName + "']")).click();
    }
}
