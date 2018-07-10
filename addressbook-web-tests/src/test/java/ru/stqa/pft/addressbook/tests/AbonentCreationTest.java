package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.getNavigationHelper().gotoHome();
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        app.getAbonentHelper().gotoAddNew();
        AbonentData abonent = new AbonentData("имя", "фамилия","телефон");
        app.getAbonentHelper().fillNewAbonentForm(abonent, true);
        app.getAbonentHelper().submitNewAbonent();
        app.getAbonentHelper().returnHomePage();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(after.size(), befor.size() + 1);


        int max = 0;
        for (AbonentData a: after){
            if (a.getId() > max){
                max = a.getId();
            }
        }
        abonent.setId(max);
        befor.add(abonent);
        Assert.assertEquals(new HashSet<Object>(befor), new HashSet<Object>(after));

    }


}
