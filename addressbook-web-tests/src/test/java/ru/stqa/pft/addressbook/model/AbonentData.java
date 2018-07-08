package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private final String name;
    private final String secondname;
    private final String mobilePhone;
    private final String email;
    private final String address;
    private String group;

    public AbonentData(String name, String secondname, String mobilePhone, String email, String address, String group) {
        this.name = name;
        this.secondname = secondname;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
        this.group = group;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (secondname != null ? !secondname.equals(that.secondname) : that.secondname != null) return false;
        return mobilePhone != null ? mobilePhone.equals(that.mobilePhone) : that.mobilePhone == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbonentData{" +
                "name='" + name + '\'' +
                '}';
    }
}
