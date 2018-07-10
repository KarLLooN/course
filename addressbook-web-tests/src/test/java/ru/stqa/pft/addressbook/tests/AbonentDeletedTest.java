package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.List;

public class AbonentDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHome();
        if (!app.getAbonentHelper().isThereAAbonent()) {
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2", "2606_1_2", "+7777"), true);
        }
    }

    @Test
    public void testAbonentDeleted() {
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        app.getAbonentHelper().abonentSelected(befor.size() - 1);
        app.getAbonentHelper().abonentDelete();
        app.getNavigationHelper().closeAlert();
        app.getNavigationHelper().gotoHome();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(after.size(), befor.size() - 1);

        befor.remove(befor.size() - 1);
        Assert.assertEquals(befor, after);

    }
}