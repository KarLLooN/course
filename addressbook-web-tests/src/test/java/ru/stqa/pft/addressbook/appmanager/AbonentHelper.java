package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentHelper extends HelperBase {

    public AbonentHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewAbonent() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewAbonentForm(AbonentData abonentData, boolean creation) {
        type(By.name("firstname"), abonentData.getName());
        type(By.name("lastname"), abonentData.getSecondname());
        type(By.name("mobile"), abonentData.getMobilePhone());
        type(By.name("email"), abonentData.getEmail());
        type(By.name("address"), abonentData.getAddress());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(abonentData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void abonentSelected() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void abonentDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


    public void abonentModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    }


    public void submitAbonentModification() {
        click(By.xpath("//div[@id='content']/form[1]"));
    }
}

