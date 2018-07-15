package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.ArrayList;
import java.util.List;

public class AbonentHelper extends HelperBase {

    public AbonentHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submit() {
        click(By.name("submit"));
    }

    public void fillNewAbonentForm(AbonentData abonentData, boolean creation) {
        type(By.name("firstname"), abonentData.getName());
        type(By.name("lastname"), abonentData.getSecondname());
        type(By.name("mobile"), abonentData.getMobilePhone());


    }

    public void abonentSelected(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void abonentDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void delete(int index) {
        abonentSelected(index);
        abonentDelete();
        closeAlert();
        home();
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


    public void abonentModification(int index) {
        wd.findElements(By.xpath("//td[8]/a/img")).get(index).click();
    }

    public void submitAbonentModification() {
        click(By.name("update"));
    }

    public boolean isThereAAbonent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void addNew() {
        click(By.linkText("add new"));
    }

    public void create(AbonentData abonent, boolean b) {
        addNew();
        fillNewAbonentForm(abonent, true);
        submit();
        returnHomePage();
    }

    public void modify(int index, AbonentData abonent) {
        abonentSelected(index);
        abonentModification(index);
        fillNewAbonentForm(abonent, false);
        submitAbonentModification();
        returnToHomePage();
    }

    public void returnToHomePage() {

        click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
    }

    public int getAbonentCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<AbonentData> list() {
        List<AbonentData> abonents = new ArrayList<AbonentData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for(WebElement element : elements){
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String secondname = element.findElement(By.xpath("./td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            abonents.add(new AbonentData().withId(id).withName(name).withSecondname(secondname));
        }
        return abonents;
    }
}

