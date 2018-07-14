package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("test1", null, null));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> befor = app.group().list();
        int index = befor.size() - 1;
        GroupData group = new GroupData(befor.get(befor.size() - 1).getId(), "test1", "test5", "test7");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(index);
        befor.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        befor.sort(byId);
        after.sort(byId);
        Assert.assertEquals(befor, after);
    }
}