package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("abonent")
@Entity
@Table(name = "addressbook")
public class AbonentData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Expose
    @Column(name = "lastname")
    private String lastname;

     @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Type(type = "text")
    private String email;
    @Expose
    @Type(type = "text")
    private String email2;
    @Expose
    @Type(type = "text")
    private String address;
    @Expose
    @Type(type = "text")
    private String email3;

    @Transient
    @Expose
    private String allPhones;

    @Transient
    @Expose
    private String allEmails;

    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();


    public AbonentData withPhoto(File photo) {
        this.photo = photo.getPath();
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

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
        return allEmails != null ? allEmails.equals(that.allEmails) : that.allEmails == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
        result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
        return result;
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
        return new File(photo);
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public AbonentData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
