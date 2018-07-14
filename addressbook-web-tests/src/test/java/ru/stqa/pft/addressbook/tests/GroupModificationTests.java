package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> befor = app.group().all();
        GroupData modifiedGroup = befor.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Tets1").withHeader("Test2").withFooter("Test3");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(modifiedGroup);
        befor.add(group);
        Assert.assertEquals(befor, after);
    }
}