package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AbonentAddToGroupTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().abonents().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().home();
            File photo = new File("src/test/resources/1.bmp");
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo).inGroup(groups.iterator().next()), true);
        }
    }

    @Test
    public void testAbonentAddToGroup(){
        Abonents befor = app.db().abonents();
        AbonentData newAbonent = befor.iterator().next();
        app.goTo().home();
        app.abonent().addAbonentToGroup(newAbonent);
        app.goTo().home();
        Abonents after = app.db().abonents();
        assertThat(after, equalTo
                (befor.withAdded(newAbonent.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
        verifyGroupListInUi();
    }
}