package ArrayList;

public class Contacto {
private String name;
private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public static Contacto createContact(String name, String phoneNumber) {
        return new Contacto(name, phoneNumber);
    }
}
