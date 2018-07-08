package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentDeletedTest extends TestBase {

    @Test
    public void testAbonentDeleted() {

        app.getNavigationHelper().gotoHome();
        if (!app.getAbonentHelper().isThereAAbonent()) {
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2", "2606_1_2", "+7777", "@", "boloto", "test1"), true);
        }
        int befor = app.getAbonentHelper().getAbonentCount();
        app.getAbonentHelper().abonentSelected(befor - 1);
        app.getAbonentHelper().abonentDelete();
        app.getNavigationHelper().closeAlert();
        app.getNavigationHelper().gotoHome();
        int after = app.getAbonentHelper().getAbonentCount();
        Assert.assertEquals(after, befor - 1);

    }
}