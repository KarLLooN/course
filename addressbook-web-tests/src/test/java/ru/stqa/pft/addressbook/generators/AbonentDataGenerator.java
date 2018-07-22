package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AbonentDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

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
        save(abonents, new File(file));
    }

    private void save(List<AbonentData> abonents, File file) throws IOException {
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