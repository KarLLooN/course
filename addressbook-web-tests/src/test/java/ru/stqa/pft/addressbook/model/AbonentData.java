package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private final String id;
    private final String name;
    private final String secondname;
    private final String mobilePhone;
    private final String email;
    private final String address;
    private String group;

    public AbonentData(String name, String secondname, String mobilePhone, String email, String address, String group) {
        this.id = null;
        this.name = name;
        this.secondname = secondname;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
        this.group = group;
    }

    public AbonentData(String id, String name, String secondname, String mobilePhone, String email, String address, String group) {
        this.id = id;
        this.name = name;
        this.secondname = secondname;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return secondname != null ? secondname.equals(that.secondname) : that.secondname == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbonentData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondname='" + secondname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }

}
