package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void fillNewAbonentForm(AbonentData abonentData) {
        type(By.name("firstname"), abonentData.getName());
        type(By.name("lastname"), abonentData.getLastName());
        type(By.name("mobile"), abonentData.getMobilePhone());
        type(By.name("email"), abonentData.getEmail());
        type(By.name("address2"), abonentData.getAddress());
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

