package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentModificationsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size() == 0) {
            File photo = new File("src/test/resources/1.bmp");
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo), true);
        }
    }

    @Test(enabled = true)
    public void testAbonentModifications() {
        Abonents befor = app.abonent().all();
        AbonentData modifyAbonent = befor.iterator().next();
        File photo = new File("src/test/resources/1.bmp");
        AbonentData abonent = new AbonentData()
                .withId(modifyAbonent.getId()).withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo);
        app.abonent().modify(abonent);
        assertThat(app.abonent().count(), equalTo(befor.size()));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo(befor.withOut(modifyAbonent).withAdded(abonent)));
    }


}