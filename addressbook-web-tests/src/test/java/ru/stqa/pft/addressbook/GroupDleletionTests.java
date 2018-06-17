package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDleletionTests extends TestBase {


    @Test
    public void testGroupDleletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }


}
