package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.Set;

public class AbonentCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.goTo().home();
        Set<AbonentData> befor = app.abonent().all();
        app.abonent().addNew();
        AbonentData abonent = new AbonentData().withName("Name1").withSecondname("Sec_name1");
        app.abonent().create(abonent, true);
        Set<AbonentData> after = app.abonent().all();
        Assert.assertEquals(after.size(), befor.size() + 1);

        abonent.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt());
        befor.add(abonent);
        Assert.assertEquals(befor,after);

    }


}
