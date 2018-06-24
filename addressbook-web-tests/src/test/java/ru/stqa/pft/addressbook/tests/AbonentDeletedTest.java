package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AbonentDeletedTest extends TestBase{

    @Test
    public void testAbonentDeleted(){

        app.getNavigationHelper().gotoHome();
        app.getAbonentHelper().abonentSelected();
        app.getAbonentHelper().abonentDeleted();
        app.getNavigationHelper().closeAlert();
    }
}