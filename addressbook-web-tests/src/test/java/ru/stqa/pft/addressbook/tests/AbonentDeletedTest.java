package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentDeletedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().abonents().size() == 0) {
            app.goTo().home();
            File photo = new File("src/test/resources/1.bmp");
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo), true);
        }
    }

    @Test
    public void testAbonentDeleted() {
        Abonents befor = app.db().abonents();
        AbonentData deletedAonent = befor.iterator().next();
        app.abonent().delete(deletedAonent);
        assertThat(app.abonent().count(), equalTo(befor.size()-1));
        Abonents after = app.db().abonents();
        assertThat(after, equalTo(befor.withOut(deletedAonent)));

    }


}