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
        AbonentData abonent = new AbonentData().withName("Name1").withSecondname("Sec_name1");
        app.abonent().create(abonent, true);
        assertThat(app.abonent().count(), equalTo(befor.size()+1));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo
                (befor.withAdded(abonent.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt()))));
    }


}
