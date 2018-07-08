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
        type(By.name("email"), abonentData.getEmail());
        type(By.name("address"), abonentData.getAddress());

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
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    }


    public void submitAbonentModification() {
        click(By.xpath("//div[@id='content']/form[1]"));
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

    public int getAbonentCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<AbonentData> getAbonentList() {
        List<AbonentData> abonents = new ArrayList<AbonentData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for(WebElement element : elements){
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            AbonentData abonent = new AbonentData(id, name, "new_2506", null, null, null, null);
            abonents.add(abonent);
        }
        return abonents;
    }
}

