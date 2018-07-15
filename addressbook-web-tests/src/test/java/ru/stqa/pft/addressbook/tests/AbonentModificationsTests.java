package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AbonentModificationsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().list().size()==0) {
            app.abonent().create(new AbonentData()
                    .withName("Modif_create_name").withSecondname("Modif_create_secondname_2"), true);
        }
    }

    @Test(enabled = true)
    public void testAbonentModifications() {
        List<AbonentData> befor = app.abonent().list();
        int index = befor.size() - 1;
        AbonentData abonent = new AbonentData()
                .withId(befor.get(index).getId()).withName("Modify_name").withSecondname("Modify_secondname");
        app.abonent().modify(index, abonent);
        List<AbonentData> after = app.abonent().list();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(index);
        befor.add(abonent);
        Comparator<? super AbonentData> byId = (a1, a2) -> Integer.compare(a1.getId(),a2.getId());
        befor.sort(byId);
        after.sort(byId);
        Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after));
    }



}