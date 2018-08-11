package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class AbonentAddToGroupTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().abonents().size() == 0) {
            app.goTo().home();
            File photo = new File("src/test/resources/1.bmp");
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo), true);
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1"));
        }
        if (getAboentWithoutGroup() == null) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test " + (Math.random() % 100)));
        }
    }

    @Test (enabled = true)
    public void testAbonentAddToGroup() {
        AbonentData abonentData = getAboentWithoutGroup();
        app.goTo().home();
        GroupData group = getGroupWithoutInnerAbonent(abonentData);
        app.goTo().changeGroupForAdd(group.getName());
        app.abonent().addAbonentToGroup(abonentData);
        app.abonent().goToGroup();
        abonentData = getAbonentById(abonentData.getId());
        //assertTrue(abonentData.getGroups().contains(group));
    }
}