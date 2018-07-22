package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validAbonents() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/abonents.csv"));
        String line = reader.readLine();
        File photo = new File("src/test/resources/1.bmp");
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{new AbonentData().withFirstname(split[0]).withLastname(split[1]).withPhoto(photo)});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validAbonents")
    public void testAbonentCreation(AbonentData abonent) {

        app.goTo().home();
        Abonents befor = app.abonent().all();
        app.abonent().addNew();
        app.abonent().create(abonent, true);
        assertThat(app.abonent().count(), equalTo(befor.size()+1));
        Abonents after = app.abonent().all();
        assertThat(after, equalTo
                (befor.withAdded(abonent.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt()))));

    }
}
