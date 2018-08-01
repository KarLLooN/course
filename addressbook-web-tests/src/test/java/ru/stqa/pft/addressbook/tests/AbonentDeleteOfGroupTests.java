package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class AbonentDeleteOfGroupTests extends TestBase {

    private AbonentData newAbonent = null;

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().abonents().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().home();
            File photo = new File("src/test/resources/1.bmp");
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withPhoto(photo).inGroup(groups.iterator().next()), true);
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1"));
        }
        GroupData groupData = app.db().groups().iterator().next();
        newAbonent = groupData.getAbonents().iterator().next();
    }

    @Test(enabled = false)
    public void testAbonentDeleteOfGroup(){
        app.goTo().changeGroup("Test1");
        app.abonent().abonentSelectedById(newAbonent.getId());
        app.group().removeAbonentFromGroup();
    }
}