package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.List;

public class AbonentModificationsTests extends TestBase {

    @Test
    public void testAbonentModifications() {
        app.getNavigationHelper().gotoHome();
        if (!app.getAbonentHelper().isThereAAbonent()) {
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2", "2606_1_2", "+7777", "@", "boloto", "test1"), true);
        }
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        app.getAbonentHelper().abonentSelected(befor.size() - 1);
        app.getAbonentHelper().abonentModification();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("New_2506", "new_2506", "sdds", "sdsd", "new", null), false);
        app.getAbonentHelper().submitAbonentModification();
        app.getNavigationHelper().returnToHomePage();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(befor.size(), after.size());
    }

}