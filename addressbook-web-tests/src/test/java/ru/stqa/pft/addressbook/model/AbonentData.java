package ru.stqa.pft.addressbook.model;

public class AbonentData {
    private final String name;
    private final String lastName;
    private final String mobilePhone;
    private final String email;
    private final String address;

    public AbonentData(String ivan, String ivanov, String s, String s1, String moscow) {
        name = ivan;
        lastName = ivanov;
        mobilePhone = s;
        email = s1;
        this.address = moscow;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
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
}