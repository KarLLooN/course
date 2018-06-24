package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.getNavigationHelper().gotoAddNew();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("asas","asasss","1212212","323","dffdf"));
        app.getAbonentHelper().submitNewAbonent();
        app.getAbonentHelper().returnHomePage();
    }







}
