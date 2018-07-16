package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentModificationsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size() == 0) {
            app.abonent().create(new AbonentData()
                    .withName("Modif_create_name").withSecondname("Modif_create_secondname_2"), true);
        }
    }

    @Test(enabled = true)
    public void testAbonentModifications() {
        Abonents befor = app.abonent().all();
        AbonentData modifyAbonent = befor.iterator().next();
        AbonentData abonent = new AbonentData()
                .withId(modifyAbonent.getId()).withName("Modify_name").withSecondname("Modify_secondname");
        app.abonent().modify(abonent);
        assertThat(app.abonent().count(), equalTo(befor.size()));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo(befor.withOut(modifyAbonent).withAdded(abonent)));
    }


}