package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.List;

public class AbonentDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().list().size() == 0) {
            app.abonent().create(new AbonentData().withName("Deleted_1_name").withSecondname("deleted_secondname_2"), true);
        }
    }

    @Test
    public void testAbonentDeleted() {
        List<AbonentData> befor = app.abonent().list();
        int index = befor.size() - 1;
        app.abonent().delete(index);
        List<AbonentData> after = app.abonent().list();
        Assert.assertEquals(after.size(), befor.size() - 1);

        befor.remove(index);
        Assert.assertEquals(befor, after);

    }


}