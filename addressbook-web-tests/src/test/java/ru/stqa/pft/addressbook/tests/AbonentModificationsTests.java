package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentModificationsTests extends TestBase{

    @Test
    public void testAbonentModifications(){

        app.getNavigationHelper().gotoHome();
        app.getAbonentHelper().abonentModification();
        app.getAbonentHelper().gotoAbonentDetails();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("Отредакт","Отредакт","1212212","323","dffdf"));
        app.getAbonentHelper().submitAbonentModification();
        app.getNavigationHelper().gotoHome();
    }

}