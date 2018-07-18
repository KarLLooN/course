package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size() == 0) {
            app.abonent().create(new AbonentData().withFirstname("Deleted_1_name").withLastname("deleted_secondname_2"), true);
        }
    }

    @Test
    public void testAbonentDeleted() {
        Abonents befor = app.abonent().all();
        AbonentData deletedAonent = befor.iterator().next();
        app.abonent().delete(deletedAonent);
        assertThat(app.abonent().count(), equalTo(befor.size()-1));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo(befor.withOut(deletedAonent)));

    }


}