package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDleletionTests extends TestBase {


    @Test
    public void testGroupDleletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }


}
