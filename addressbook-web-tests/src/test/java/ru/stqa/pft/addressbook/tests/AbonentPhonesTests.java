package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentPhonesTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.abonent().all().size() == 0) {
            app.abonent().create(new AbonentData()
                    .withFirstname("Name1").withLastname("Sec_name1").withMobilePhone("45454").withHomePhone("555").withWorkPhone("2311313")
                    .withEmail("eemail1").withEmail2("email2").withEmail3("email3").withAddress("asas"), true);
        }
    }

    @Test
    public void testAbonentPhones() {
        app.goTo().home();
        AbonentData abonent = app.abonent().all().iterator().next();
        AbonentData abonentInfoFromEditForm = app.abonent().infoFromEditForm(abonent);

        assertThat(abonent.getAllPhones(), equalTo(mergePhones(abonentInfoFromEditForm)));
        assertThat(abonent.getAllEmails(), equalTo(mergeEmails(abonentInfoFromEditForm)));
        assertThat(abonent.getAddress(), equalTo(mergeAddress(abonentInfoFromEditForm)));

    }

    private String mergeAddress(AbonentData abonent) {
        return Arrays.asList(abonent.getAddress())
                .stream().filter((s) -> !s.equals(""))
//                .map(AbonentPhonesTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(AbonentData abonent) {
        return Arrays.asList(abonent.getEmail(), abonent.getEmail2(), abonent.getEmail3())
                .stream().filter((s) -> !s.equals(""))
//                .map(AbonentPhonesTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(AbonentData abonent) {
        return Arrays.asList(abonent.getHomePhone(), abonent.getMobilePhone(), abonent.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(AbonentPhonesTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}