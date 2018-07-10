package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.HashSet;
import java.util.List;

public class AbonentModificationsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHome();
        if (!app.getAbonentHelper().isThereAAbonent()) {
            app.getAbonentHelper().createAbonent(new AbonentData("2506_1_2", "2606_1_2", "+7777"), true);
        }
    }

    @Test(enabled = true)
    public void testAbonentModifications() {
        List<AbonentData> befor = app.getAbonentHelper().getAbonentList();
        int index = befor.size() - 1;
        AbonentData abonent = new AbonentData(befor.get(befor.size()-1).getId(),"имя", "фамилия", null);
        app.getAbonentHelper().modifyAbonent(index, abonent);
        List<AbonentData> after = app.getAbonentHelper().getAbonentList();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(index);
        befor.add(abonent);
        Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after));
    }



}