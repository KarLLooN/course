package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String secondname;
    private String mobilePhone;

    public void setId(int id) {
        this.id = id;
    }

    public AbonentData withId(int id) {
        this.id = id;
        return this;
    }

    public AbonentData withName(String name) {
        this.name = name;
        return this;
    }

    public AbonentData withSecondname(String secondname) {
        this.secondname = secondname;
        return this;
    }

    public AbonentData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentData that = (AbonentData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return secondname != null ? secondname.equals(that.secondname) : that.secondname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
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

    public int getId() {
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


}
