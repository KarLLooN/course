package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups befor = app.db().groups();
        GroupData modifiedGroup = befor.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Tets1").withHeader("Test2").withFooter("Test3");
        app.goTo().groupPage();
        app.group().modify(group);
        Assert.assertEquals(app.group().count(), befor.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(befor.withOut(modifiedGroup).withAdded(group)));
        verifyGroupListInUi();
    }


}