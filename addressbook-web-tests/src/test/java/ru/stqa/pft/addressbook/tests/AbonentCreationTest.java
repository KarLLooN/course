package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentCreationTest extends TestBase {


    @Test
    public void testAbonentCreation() {

        app.goTo().home();
        Abonents befor = app.abonent().all();
        app.abonent().addNew();
        AbonentData abonent = new AbonentData()
                .withFirstname("Name1").withLastname("Sec_name1")
                .withMobilePhone("45454").withHomePhone("555").withWorkPhone("2311313")
                .withEmail("em1_crreate").withEmail2("em2_create").withEmail3("em3_create").withAddress("address_create");
        app.abonent().create(abonent, true);
        assertThat(app.abonent().count(), equalTo(befor.size()+1));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo
                (befor.withAdded(abonent.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt()))));
    }


}
