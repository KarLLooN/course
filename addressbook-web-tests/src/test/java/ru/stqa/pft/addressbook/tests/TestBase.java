package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTetsStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with parameters " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListInUi() {
        if (Boolean.getBoolean("verifyUi")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }

    public void verifyAbonentListInUi() {
        if (Boolean.getBoolean("verifyAbonentUi")) {
            Abonents dbAbonents = app.db().abonents();
            Abonents uiAbonents = app.abonent().all();
            assertThat(uiAbonents, equalTo(dbAbonents.stream()
                    .map((a) -> new AbonentData().withId(a.getId()).withFirstname(a.getFirstname()).withLastname(a.getLastname()))
                    .collect(Collectors.toSet())));
        }
    }

    protected AbonentData getAboentWithoutGroup() {
        Abonents abonents = app.db().abonents();
        Groups groups = app.db().groups();
        return abonents.stream().filter(abonentData -> !abonentData.getGroups().containsAll(groups)).findFirst()
                .orElse(null);//возвращаем список абонентов без группы
    }

    protected AbonentData getAbonentById(int id) {
        Abonents abonents = app.db().abonents();
        return abonents.stream().filter(abonentData -> abonentData.getId() == id).findFirst().orElse(null);
    }

    protected GroupData getGroupWithoutInnerAbonent(AbonentData abonent) {
        Groups groups = app.db().groups();
        for (GroupData group : groups) {
            if (!abonent.getGroups().contains(group)) {
                return group;
            }
        }
        throw new AssertionError("Не найдена группа без данного абонента " + abonent.toString());
    }
}