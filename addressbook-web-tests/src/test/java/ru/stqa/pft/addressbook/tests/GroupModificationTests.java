package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> befor = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(befor.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(befor.get(befor.size() -1).getId(),"test1", "test5", "test7");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(befor.size(), after.size());

        befor.remove(befor.size()-1);
        befor.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        befor.sort(byId);
        after.sort(byId);
        Assert.assertEquals(befor,after);
    }
}