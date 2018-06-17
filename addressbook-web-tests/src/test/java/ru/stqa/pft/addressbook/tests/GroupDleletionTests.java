package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDleletionTests extends TestBase {


    @Test
    public void testGroupDleletion() {
        app.gotoGroupPage();
        app.getGroupHalper().selectGroup();
        app.getGroupHalper().deleteSelectedGroups();
        app.getGroupHalper().returnToGroupPage();
    }


}
