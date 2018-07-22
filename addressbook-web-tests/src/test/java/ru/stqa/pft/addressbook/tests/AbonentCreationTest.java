package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validAbonents() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/abonents.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(AbonentData.class);
        List<AbonentData> abonents = (List<AbonentData>) xStream.fromXML(xml);
        return abonents.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
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
