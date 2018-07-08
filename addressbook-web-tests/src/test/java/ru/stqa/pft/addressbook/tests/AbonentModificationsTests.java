package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.HashSet;
import java.util.List;

public class AbonentModificationsTests extends TestBase {

    @Test
    public void testAbonentModifications() {
        app.getNavigationHelper().gotoHome();
        if (!app.getAbonentHelper().isThereAAbonent()) {
            app.getAbonentHelper().createAbonent(new AbonentData("New_2511", "new_2512", null, null, null, null), false);
        }
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        app.getAbonentHelper().abonentSelected(befor.size() - 1);
        app.getAbonentHelper().abonentModification();
        AbonentData abon = new AbonentData(befor.get(befor.size()-1).getId(),"New_2506", "new_25", null, null, null, null);
        app.getAbonentHelper().fillNewAbonentForm(abon, false);
        app.getAbonentHelper().submitAbonentModification();
        app.getNavigationHelper().returnToHomePage();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(befor.size() - 1);
        befor.add(abon);
        Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after));
    }

}