package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups befor = app.group().all();
        GroupData modifiedGroup = befor.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Tets1").withHeader("Test2").withFooter("Test3");
        app.group().modify(group);
        Assert.assertEquals(app.group().count(), befor.size());
        Groups after = app.group().all();
        assertThat(after, equalTo(befor.withOut(modifiedGroup).withAdded(group)));
    }
}