package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().GroupPage();
        Set<GroupData> befor = app.group().all();
        app.group().initGroupCreation();
        GroupData group = new GroupData().withName("Test2");
        app.group().fillGroupForm(group);
        app.group().submitGroupCreation();
        app.group().returnToGroupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), befor.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        befor.add(group);
        Assert.assertEquals(befor,after);
    }

    }
