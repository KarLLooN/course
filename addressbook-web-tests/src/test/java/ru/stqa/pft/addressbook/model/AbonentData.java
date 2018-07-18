package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;

    public void setId(int id) {
        this.id = id;
    }

    public AbonentData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        return workPhone != null ? workPhone.equals(that.workPhone) : that.workPhone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        return result;
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

    @Override
    public String toString() {
        return "AbonentData{" +
                "id='" + id + '\'' +
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
}
