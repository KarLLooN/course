package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.GroupData;

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
        Assert.assertEquals(new HashSet<Object>(befor),new HashSet<>(after));
    }
}