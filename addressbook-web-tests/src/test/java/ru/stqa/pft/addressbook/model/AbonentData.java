package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private int id;
    private final String name;
    private final String secondname;
    private final String mobilePhone;

    public void setId(int id) {
        this.id = id;
    }


    public AbonentData(String name, String secondname, String mobilePhone) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.secondname = secondname;
        this.mobilePhone = mobilePhone;

    }

    public AbonentData(int id, String name, String secondname, String mobilePhone) {
        this.id = id;
        this.name = name;
        this.secondname = secondname;
        this.mobilePhone = mobilePhone;

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
