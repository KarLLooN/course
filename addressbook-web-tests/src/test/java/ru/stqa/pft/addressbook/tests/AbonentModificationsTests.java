package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentModificationsTests extends TestBase {

    @Test
    public void testAbonentModifications() {
        app.getNavigationHelper().gotoHome();
        app.getAbonentHelper().abonentSelected();
        app.getAbonentHelper().abonentModification();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("New12", "sdsd", "sdds", "sdsd", "new"));
        app.getAbonentHelper().submitAbonentModification();
        app.getNavigationHelper().returnToHomePage();
    }

}