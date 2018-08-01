package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AbonentAddToGroupTests extends TestBase {

    private AbonentData newAbonent = null;

    @BeforeMethod
    public void ensurePreconditions() {

        Abonents befor = app.db().abonents();
        befor.stream().forEach((abonentData -> app.abonent().delete(abonentData)));
        for (AbonentData abonent : befor) {
            if (abonent.getGroups() == null || abonent.getGroups().size() < 1) {
                newAbonent = abonent;
            }
        }
        if (app.db().abonents().size() == 0 || newAbonent == null) {
            app.goTo().home();
            File photo = new File("src/test/resources/1.bmp");
            Random random = new Random(0);
            app.abonent().create(new AbonentData()
                    .withFirstname("Name" + random.nextInt(100)).withLastname("Sec_name" + random.nextInt(100)).withPhoto(photo), true);
            befor = app.db().abonents();
            for (AbonentData abonent : befor) {
                if (abonent.getGroups() == null || abonent.getGroups().size() < 1) {
                    newAbonent = abonent;
                }
            }
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1"));
        }

    }

    @Test
    public void testAbonentAddToGroup() {
        Abonents befor = app.db().abonents();
        app.goTo().home();
        app.abonent().addAbonentToGroup(newAbonent);
        app.abonent().goToGroup();
        Abonents after = app.db().abonents();
        assertThat(after, equalTo
                (befor.withAdded(newAbonent.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
        Assert.assertTrue(after.iterator().next().getGroups().size() > newAbonent.getGroups().size());
    }
}