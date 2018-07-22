package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.AbonentData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AbonentDataGenerator {

    @Parameter(names = "-c", description = "Abonent count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        AbonentDataGenerator generator = new AbonentDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<AbonentData> abonents = generateAbonents(count);
        if (format.equals("csv")) {
            saveAsCsv(abonents, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(abonents, new File(file));
        }
        else if (format.equals("json")) {
            saveAsJson(abonents, new File(file));
        }
        else {
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsJson(List<AbonentData> abonents, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(abonents);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<AbonentData> abonents, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(AbonentData.class);
        String xml = xStream.toXML(abonents);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<AbonentData> abonents, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (AbonentData abonent : abonents) {
            writer.write(String.format("%s;%s\n", abonent.getFirstname(), abonent.getLastname()));
        }
        writer.close();
    }

    private List<AbonentData> generateAbonents(int count) {
        List<AbonentData> abonents = new ArrayList<AbonentData>();
        for (int i = 0; i < count; i++) {
            abonents.add(new AbonentData().withFirstname(String.format("firstname %s", i))
                    .withLastname(String.format("lastname %s", i)));
        }
        return abonents;
    }
}