package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentAddToGroupTests extends TestBase{

    @Test
    public void testAbonentAddToGroup(){
        Groups groups = app.db().groups();
        Abonents befor = app.db().abonents();
        File photo = new File("src/test/resources/1.bmp");
        AbonentData newAbonent = new AbonentData().withFirstname("Nmae1").withLastname("Last1").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.goTo().home();
        app.abonent().addNew();
        app.abonent().create(newAbonent, true);
        app.goTo().home();
//        assertThat(app.abonent().count(), equalTo(befor.size() + 1));
//        Abonents after = app.db().abonents();
//        assertThat(after, equalTo
//                (befor.withAdded(newAbonent.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    }
}