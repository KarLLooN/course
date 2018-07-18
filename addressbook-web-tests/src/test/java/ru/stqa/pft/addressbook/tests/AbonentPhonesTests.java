package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentPhonesTests extends TestBase{

    @Test
    public void testAbonentPhones(){
        app.goTo().home();
        AbonentData abonent = app.abonent().all().iterator().next();
        AbonentData abonentInfoFromEditForm = app.abonent().infoFromEditForm(abonent);

        assertThat(abonent.getHomePhone(), equalTo(cleaned(abonentInfoFromEditForm.getHomePhone())));
        assertThat(abonent.getMobilePhone(), equalTo(cleaned(abonentInfoFromEditForm.getMobilePhone())));
        assertThat(abonent.getWorkPhone(), equalTo(cleaned(abonentInfoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}