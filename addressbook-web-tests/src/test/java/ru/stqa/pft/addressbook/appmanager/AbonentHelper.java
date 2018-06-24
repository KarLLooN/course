package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentHelper extends HelperBase {

    public AbonentHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewAbonent() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewAbonentForm(AbonentData abonentData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(abonentData.getName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(abonentData.getLastName());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(abonentData.getMobilePhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(abonentData.getEmail());
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(abonentData.getAddress());
    }

    public void abonentSelected(){
        click(By.name("selected[]"));
    }

    public void abonentDelete(){ click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));}

    public void abonentSelectedAll(){
        click(By.id("MassCB"));
    }
    public void abonentModification(){
        click(By.name("modify"));
    }

    public void gotoAbonentDetails(){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
    }

    public void submitAbonentModification() {
        click(By.name("update"));
    }
}

