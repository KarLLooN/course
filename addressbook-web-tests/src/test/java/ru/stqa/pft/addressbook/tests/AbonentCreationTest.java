package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("2506_1_2","2606_1_2",null,null,null,null), true);
        app.getAbonentHelper().submitNewAbonent();
        app.getAbonentHelper().returnHomePage();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(after.size(), befor.size() +1);

    }







}
