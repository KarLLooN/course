package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentDataCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.gotoAddNew();
        app.getAbonentHelper().fillNewAbonentForm(new AbonentData("Ivan", "Ivanov", "+78968968989", "ivas@mai.com", "Moscow"));
        app.getAbonentHelper().submitNewAbonent();
        app.getAbonentHelper().returnHomePage();
    }


}
