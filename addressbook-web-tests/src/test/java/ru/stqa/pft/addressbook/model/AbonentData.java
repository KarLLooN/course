package ru.stqa.pft.addressbook.model;

import java.io.File;

public class AbonentData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String email;
    private String email2;
    private String address;
    private String email3;
    private String allPhones;
    private String allEmails;
    private File photo;


    public AbonentData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public AbonentData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public AbonentData withId(int id) {
        this.id = id;
        return this;
    }

    public AbonentData withFirstname(String name) {
        this.firstname = name;
        return this;
    }

    public AbonentData withLastname(String secondname) {
        this.lastname = secondname;
        return this;
    }

    public AbonentData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public AbonentData withEmail(String email) {
        this.email = email;
        return this;
    }


    public AbonentData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }


    public AbonentData withAddress(String address) {
        this.address = address;
        return this;
    }


    public AbonentData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }



    public AbonentData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public AbonentData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public AbonentData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    @Override
    public String toString() {
        return "AbonentData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAddress() {
        return address;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public File getPhoto() {
        return photo;
    }
}
