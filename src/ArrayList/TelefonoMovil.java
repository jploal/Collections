package ArrayList;

import java.util.ArrayList;

public class TelefonoMovil {

    private String myNumber;
    private ArrayList<Contacto> myContacts;


    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            System.out.println("Contacto ya existe");
            return false;
        }
        myContacts.add(contacto);
        System.out.println("Contacto registrado");
        return true;
    }

    public boolean updateContact(Contacto antiguo, Contacto nuevo) {
        int oldIndex = findContact(antiguo.getName());

        if (oldIndex < 0) {
            System.out.println("Contacto antiguo no existe");
            return false;
        }

        if (findContact(nuevo.getName()) >= 0 &&
                !antiguo.getName().equals(nuevo.getName())) {
            System.out.println("Contacto nuevo ya existe");
            return false;
        }
        myContacts.set(oldIndex, nuevo);
        System.out.println("Contacto actualizado");
        return true;
    }

    public boolean removeContact(Contacto contacto) {
        int index = findContact(contacto.getName());

        if (index < 0) {
            System.out.println("Contacto no existe");
            return false;
        }

        myContacts.remove(index);
        System.out.println("Contacto eliminado");
        return true;
    }

    private int findContact(Contacto contacto) {
        return findContact(contacto.getName());
    }

    int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact(String name) {
        int index = findContact(name);
        if (index < 0) {
            return null;
        }
        return myContacts.get(index);
    }

    public void printContacts() {
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contacto c = myContacts.get(i);
            System.out.println(
                    (i + 1) + ". " + c.getName() + " -> " + c.getPhoneNumber()
            );
        }
    }
}
