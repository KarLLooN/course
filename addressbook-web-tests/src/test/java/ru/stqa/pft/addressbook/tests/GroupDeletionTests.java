package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups befor = app.db().groups();
        GroupData deletedGroup = befor.iterator().next();
        app.group().delete(deletedGroup);
        Assert.assertEquals(app.group().count(), befor.size()-1);
        Groups after = app.db().groups();
        assertThat(after, equalTo(befor.withOut(deletedGroup)));

    }


}
