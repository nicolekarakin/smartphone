package model;

public class Friend extends Contact{
    private String name;
    private String phoneNumber;

    public Friend() {}
    public Friend(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }
}
