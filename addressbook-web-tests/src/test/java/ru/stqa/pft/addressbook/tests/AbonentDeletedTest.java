package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentDeletedTest extends TestBase{

    @Test
    public void testAbonentDeleted(){

        app.getNavigationHelper().gotoHome();
        if (! app.getAbonentHelper().isThereAAbonent()){
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2","2606_1_2","+7777","@","boloto","test1"), true);
        }
        app.getAbonentHelper().abonentSelected();
        app.getAbonentHelper().abonentDelete();
        app.getNavigationHelper().closeAlert();

    }
}