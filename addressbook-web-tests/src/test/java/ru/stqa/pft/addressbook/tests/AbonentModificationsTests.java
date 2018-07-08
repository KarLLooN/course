package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentModificationsTests extends TestBase {

    @Test
    public void testAbonentModifications() {
        app.getNavigationHelper().gotoHome();
        int befor = app.getAbonentHelper().getAbonentCount();
        if (! app.getAbonentHelper().isThereAAbonent()){
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2","2606_1_2","+7777","@","boloto","test1"), true);
        }
        app.getAbonentHelper().abonentSelected(befor - 1);
        app.getAbonentHelper().abonentModification();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("New_2506", "new_2506", "sdds", "sdsd", "new", null), false);
        app.getAbonentHelper().submitAbonentModification();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getAbonentHelper().getAbonentCount();
        Assert.assertEquals(befor,after);
    }

}