package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AbonentData;
import ru.stqa.pft.addressbook.model.Abonents;

import java.util.List;

public class AbonentHelper extends HelperBase {

    public AbonentHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void submit() {
        click(By.name("submit"));
    }

    public void fillNewAbonentForm(AbonentData abonentData, boolean creation) {
        type(By.name("firstname"), abonentData.getFirstname());
        type(By.name("lastname"), abonentData.getLastname());
        type(By.name("mobile"), abonentData.getMobilePhone());
        type(By.name("home"), abonentData.getHomePhone());
        type(By.name("work"), abonentData.getWorkPhone());
        type(By.name("email"), abonentData.getEmail());
        type(By.name("email2"), abonentData.getEmail2());
        type(By.name("email3"), abonentData.getEmail3());
        type(By.name("address"), abonentData.getAddress());
        attach(By.name("photo"), abonentData.getPhoto());

        if(creation){
            if(abonentData.getGroups().size() > 0){
                Assert.assertTrue(abonentData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group")))
                        .selectByVisibleText(abonentData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void abonentSelectedById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void abonentDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void delete(AbonentData abonent) {
        abonentSelectedById(abonent.getId());
        abonentDelete();
        abonentCach = null;
        closeAlert();
        home();
    }

    public void addAbonentToGroup(AbonentData abonent){
        abonentSelectedById(abonent.getId());
        abonentAddGroup();
        abonentCach = null;
        home();
    }

    private void abonentAddGroup() {
        click(By.cssSelector("input[name='add']"));
    }

    public void home() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.xpath("//div[@id='nav']//a[.='home']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }


    public void abonentModification(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void submitAbonentModification() {
        click(By.name("update"));
    }

    public boolean isThereAAbonent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void addNew() {
        click(By.linkText("add new"));
    }

    public void create(AbonentData abonent, boolean b) {
        addNew();
        fillNewAbonentForm(abonent, true);
        submit();
        abonentCach = null;
        returnHomePage();
    }

    public void modify(AbonentData abonent) {
        abonentModification(abonent.getId());
        fillNewAbonentForm(abonent, false);
        submitAbonentModification();
        abonentCach = null;
        returnToHomePage();
    }

    public void returnToHomePage() {

        click(By.xpath("//div[@class='msgbox']//a[.='home page']"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Abonents abonentCach = null;

    public Abonents all() {
        if(abonentCach != null){
            return new Abonents(abonentCach);
        }
        abonentCach = new Abonents();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath("./td[3]")).getText();
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            String address = element.findElement(By.xpath("./td[4]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = element.findElement(By.xpath("./td[6]")).getText();
            String allEmails = element.findElement(By.xpath("./td[5]")).getText();
             abonentCach.add(new AbonentData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
                    .withAllPhones(allPhones).withAllEmails(allEmails));
        }
        return new Abonents(abonentCach);
    }

    public AbonentData infoFromEditForm(AbonentData abonent){
        initAbonentModificationById(abonent.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new AbonentData().withId(abonent.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    private void initAbonentModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }


}

