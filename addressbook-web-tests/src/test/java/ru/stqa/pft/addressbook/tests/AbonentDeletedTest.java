package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AbonentDeletedTest extends TestBase{

    @Test
    public void testAbonentDeleted(){

        app.getNavigationHelper().gotoHome();
        app.getAbonentHelper().abonentSelectedAll();
        app.getAbonentHelper().abonentDelete();
        app.getNavigationHelper().closeAlert();

    }
}