package ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefono = new TelefonoMovil("123456789");

    private static void menu() {
        System.out.println("""
                Menú de opciones:
                0 - Salir
                1 - Imprimir contactos
                2 - Agregar nuevo contacto
                3 - Actualizar contacto
                4 - Eliminar contacto
                5 - Buscar contacto por nombre
                NOTA: Esta lista de contactos es Case Sensitive
                """);
    }

    public static void imprimirContacto() {
        telefono.printContacts();
    }

    public static void agregarContacto() {
        System.out.println("Introduce nombre de contacto");
        String nombre = scanner.nextLine();
        System.out.println("Introduce numero de contacto");
        String numero = scanner.nextLine();
        Contacto contacto = new Contacto(nombre, numero);
        telefono.addNewContact(contacto);
    }

    public static void actualizarContacto() {
        System.out.println("Introduce nombre de contacto existente");
        String existente = scanner.nextLine();
        if (telefono.queryContact(existente) == null) {
            System.out.println("Contacto no encontrado");
            return;
        }
        System.out.println("Introduce nombre de contacto nuevo");
        String nombre = scanner.nextLine();
        System.out.println("Introduce numero de contacto nuevo");
        String numero = scanner.nextLine();
        Contacto contacto = new Contacto(nombre, numero);
        telefono.updateContact(telefono.queryContact(existente), contacto);
    }

    public static void eliminarContacto() {
        System.out.println("Introduce nombre de contacto existente");
        String existente = scanner.nextLine();
        if (telefono.queryContact(existente) == null) {
            System.out.println("Contacto no encontrado");
            return;
        }
        telefono.removeContact(telefono.queryContact(existente));
    }

    public static void buscarContacto() {
        System.out.println("Nombre del contacto a buscar:");
        String nombre = scanner.nextLine();
        Contacto contacto = telefono.queryContact(nombre);

        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getName() + ", Teléfono: " + contacto.getPhoneNumber());
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }


    public static void main(String[] args) {
        Contacto Oscar=new Contacto("Oscar","111111111");
        telefono.addNewContact(Oscar);
        Contacto Daniela=new Contacto("Daniela","222222222");
        telefono.addNewContact(Daniela);
        Contacto MiguelA= new Contacto("MiguelA","333333333");
        telefono.addNewContact(MiguelA);
        boolean salir = false;
        int eleccion;


        while (!salir) {
            menu();
            System.out.println("Elige una opción:");
            try{
            eleccion = scanner.nextInt();
            scanner.nextLine();

            if (eleccion < 0 || eleccion > 6) {
                System.out.println("Opción no válida");
                continue;
            }

            switch (eleccion) {
                case 0 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                case 1 -> imprimirContacto();
                case 2 -> agregarContacto();
                case 3 -> actualizarContacto();
                case 4 -> eliminarContacto();
                case 5 -> buscarContacto();
            }
        }catch(InputMismatchException e){
                System.out.println("Introduce los números que haya en el menú");
                scanner.nextLine();
            }
        }
    }
}