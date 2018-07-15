package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.Set;

public class AbonentDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size() == 0) {
            app.abonent().create(new AbonentData().withName("Deleted_1_name").withSecondname("deleted_secondname_2"), true);
        }
    }

    @Test
    public void testAbonentDeleted() {
        Set<AbonentData> befor = app.abonent().all();
        AbonentData deletedAonent = befor.iterator().next();
        app.abonent().delete(deletedAonent);
        Set<AbonentData> after = app.abonent().all();
        Assert.assertEquals(after.size(), befor.size() - 1);

        befor.remove(deletedAonent);
        Assert.assertEquals(befor, after);

    }


}