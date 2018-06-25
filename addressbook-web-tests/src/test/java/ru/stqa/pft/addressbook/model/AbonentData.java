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
}
