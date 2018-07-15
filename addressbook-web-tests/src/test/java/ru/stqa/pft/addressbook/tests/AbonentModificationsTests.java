package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.HashSet;
import java.util.Set;

public class AbonentModificationsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size()==0) {
            app.abonent().create(new AbonentData()
                    .withName("Modif_create_name").withSecondname("Modif_create_secondname_2"), true);
        }
    }

    @Test(enabled = true)
    public void testAbonentModifications() {
        Set<AbonentData> befor = app.abonent().all();
        AbonentData modifyAbonent = befor.iterator().next();
        AbonentData abonent = new AbonentData()
                .withId(modifyAbonent.getId()).withName("Modify_name").withSecondname("Modify_secondname");
        app.abonent().modify(abonent);
        Set<AbonentData> after = app.abonent().all();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(modifyAbonent);
        befor.add(abonent);
        Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after));
    }



}