package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    public void submitNewAbonent() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewAbonentForm(AbonentData abonentData, boolean creation) {
        type(By.name("firstname"), abonentData.getName());
        type(By.name("lastname"), abonentData.getSecondname());
        type(By.name("mobile"), abonentData.getMobilePhone());

//        if (creation) {
//            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(abonentData.getGroup());
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
//        }


    }

    public void abonentSelected(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void abonentDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


    public void abonentModification() {
        List<WebElement> allElement=wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]"));
        int count=allElement.size()-1;
        allElement.get(count).findElement(By.xpath("./td[8]/a/img")).click();

    }


    public void submitAbonentModification() {
        click(By.name("update"));
    }

    public boolean isThereAAbonent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void gotoAddNew() {
        click(By.linkText("add new"));
    }

    public void createAbonent(AbonentData abonent, boolean b) {
        gotoAddNew();
        fillNewAbonentForm(abonent, true);
        submitNewAbonent();
        returnHomePage();
    }

    public void modifyAbonent(int index, AbonentData abonent) {
        abonentSelected(index);
        abonentModification();
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

    public List<AbonentData> getAbonentList() {
        List<AbonentData> abonents = new ArrayList<AbonentData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for(WebElement element : elements){
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String secondname = element.findElement(By.xpath("./td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            AbonentData abonent = new AbonentData(id, name, secondname, null);
            abonents.add(abonent);
        }
        return abonents;
    }
}

