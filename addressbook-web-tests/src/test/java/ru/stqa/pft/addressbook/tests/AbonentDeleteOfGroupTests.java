package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.testng.Assert.assertFalse;

public class AbonentDeleteOfGroupTests extends TestBase {

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
        if (getAbonentWithGroup() == null) {
            AbonentData abonentData = getAboentWithoutGroup();
            app.goTo().home();
            GroupData group = getGroupWithoutInnerAbonent(abonentData);
            app.goTo().changeGroupForAdd(group.getName());
            app.abonent().addAbonentToGroup(abonentData);
            app.abonent().goToGroup();
        }
    }

    private AbonentData getAbonentWithGroup() {
        Abonents abonents = app.db().abonents();
        return abonents.stream().filter(abonentData -> abonentData.getGroups().size() > 0).findFirst().orElse(null);
    }

    @Test(enabled = true)
    public void testAbonentDeleteOfGroup() {
        AbonentData abonent = getAbonentWithGroup();
        GroupData group = abonent.getGroups().iterator().next();
        app.goTo().home();
        app.goTo().changeGroupForView(group.getName());
        app.abonent().abonentSelectedById(abonent.getId());
        app.group().removeAbonentFromGroup();
        abonent = getAbonentById(abonent.getId());
        assertFalse(abonent.getGroups().contains(group));
    }


}