package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbonentCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validAbonentsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/abonents.json"))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<AbonentData> abonents = gson.fromJson(json, new TypeToken<List<AbonentData>>() {
            }.getType());
            return abonents.stream().map((a) -> new Object[]{a}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validAbonentsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/abonents.xml"))) {
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
    }

    @Test(dataProvider = "validAbonentsFromJson")
    public void testAbonentCreation(AbonentData abonent) {
        Abonents befor = app.db().abonents();
        app.goTo().home();
        app.abonent().addNew();
        app.abonent().create(abonent, true);
        assertThat(app.abonent().count(), equalTo(befor.size() + 1));
        Abonents after = app.db().abonents();
        assertThat(after, equalTo
                (befor.withAdded(abonent.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
        verifyGroupListInUi();
    }
}
