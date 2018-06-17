package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentHelper {
    protected final GroupHalper groupHalper = new GroupHalper();

    public void returnHomePage() {
        groupHalper.wd.findElement(By.linkText("home page")).click();
    }

    public void submitNewAbonent() {
        groupHalper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillNewAbonentForm(AbonentData abonent) {
        groupHalper.wd.findElement(By.name("firstname")).click();
        groupHalper.wd.findElement(By.name("firstname")).clear();
        groupHalper.wd.findElement(By.name("firstname")).sendKeys(abonent.getName());
        groupHalper.wd.findElement(By.name("lastname")).click();
        groupHalper.wd.findElement(By.name("lastname")).clear();
        groupHalper.wd.findElement(By.name("lastname")).sendKeys(abonent.getLastName());
        groupHalper.wd.findElement(By.name("mobile")).click();
        groupHalper.wd.findElement(By.name("mobile")).clear();
        groupHalper.wd.findElement(By.name("mobile")).sendKeys(abonent.getMobilePhone());
        groupHalper.wd.findElement(By.name("email")).click();
        groupHalper.wd.findElement(By.name("email")).clear();
        groupHalper.wd.findElement(By.name("email")).sendKeys(abonent.getEmail());
        groupHalper.wd.findElement(By.name("address2")).click();
        groupHalper.wd.findElement(By.name("address2")).clear();
        groupHalper.wd.findElement(By.name("address2")).sendKeys(abonent.getAddress());
    }
}