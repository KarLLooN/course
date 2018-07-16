package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void abonentSelectedById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void abonentDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void delete(AbonentData abonent) {
        abonentSelectedById(abonent.getId());
        abonentDelete();
        abonentCach = null;
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


    public void abonentModification(int id) {
        wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
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
        abonentCach = null;
        returnHomePage();
    }

    public void modify(AbonentData abonent) {
        abonentModification(abonent.getId());
        fillNewAbonentForm(abonent, false);
        submitAbonentModification();
        abonentCach = null;
        returnToHomePage();
    }

    public void returnToHomePage() {

        click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Abonents abonentCach = null;

    public Abonents all() {
        if(abonentCach != null){
            return new Abonents(abonentCach);
        }
        abonentCach = new Abonents();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String secondname = element.findElement(By.xpath("./td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            abonentCach.add(new AbonentData().withId(id).withName(name).withSecondname(secondname));
        }
        return new Abonents(abonentCach);
    }


}

