package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import ru.stqa.pft.addressbook.model.AbonentData;

public class AbonentCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.goTo().gotoHome();
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        app.getAbonentHelper().gotoAddNew();
        AbonentData abonent = new AbonentData("имя", "фамилия", "телефон");
        app.getAbonentHelper().fillNewAbonentForm(abonent, true);
        app.getAbonentHelper().submitNewAbonent();
        app.getAbonentHelper().returnHomePage();
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(after.size(), befor.size() + 1);


        abonent.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        befor.add(abonent);
        Comparator<? super AbonentData> byId = (a1, a2) -> Integer.compare(a1.getId(),a2.getId());
        befor.sort(byId);
        after.sort(byId);
        Assert.assertEquals(befor,after);

    }


}
