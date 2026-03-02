package Vuelos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Vuelos> vuelos = new ArrayList<>();

    public static void menu() {
        System.out.println("""
                =================================
                VUELOS DEL AEROPUERTO DE VALENCIA
                =================================
                1 - Imprimir todos los vuelos
                2 - Buscar un número de vuelo
                3 - Buscar vuelo por clave
                4 - Añadir vuelo nuevo
                5 - Borrar vuelo por numero
                6 - Salir
                ---------------------------------
                """);
    }

    public static void ImprimirVuelos() {
        for (Vuelos vuelo : vuelos) {
            System.out.println(vuelo);
        }
    }

    public static void buscarNumero(String num) {
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos");
        }
        for (Vuelos vuelo : vuelos) {
            if (vuelo.getNumero().equals(num)) {
                System.out.println(vuelo);
                return;
            }
        }
        System.out.println("No existe vuelo con ese numero asignado");
    }

    public static void buscarClave(String clave) {
        int contador = 0;
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos");
            return;
        }

        if (clave.equalsIgnoreCase("origen")) {
            System.out.println("Introduce ciudad de Origen");
            String ciudad = sc.nextLine();
            for (Vuelos vuelo : vuelos) {
                if (vuelo.getOrigen().equalsIgnoreCase(ciudad))
                    System.out.println(vuelo);
                contador++;
            }

        } else if (clave.equalsIgnoreCase("destino")) {
            System.out.println("Introduce ciudad de Destino");
            String ciudad = sc.nextLine();
            for (Vuelos vuelo : vuelos) {
                if (vuelo.getDestino().equalsIgnoreCase(ciudad))
                    System.out.println(vuelo);
                contador++;
            }

        } else if (clave.equalsIgnoreCase("Clase")) {
            System.out.println("Introduce Clase de billete");
            String clase = sc.nextLine();
            for (Vuelos vuelo : vuelos) {
                if (vuelo.getClase().toString().equalsIgnoreCase(clase))
                    System.out.println(vuelo);
                contador++;
            }

        } else if (clave.equalsIgnoreCase("dia")) {
            System.out.println("Introduce dia del vuelo (Formato: dd-mm)");
            String dia = sc.nextLine();
            for (Vuelos vuelo : vuelos) {
                if (vuelo.getDia().equalsIgnoreCase(dia))
                    System.out.println(vuelo);
                contador++;
            }

        } else if (contador == 0) {
            System.out.println("No existe vuelo con esas Claves");

        } else {
            System.out.println("Esa Clave no existe");
        }
    }

    public static void añadirVuelo() {
        System.out.println("Introduce Vuelo a añadir:(numero,origen,destino,dia y clase");
        String numero, origen, destino, dia, clase;

        do {
            System.out.print("Número(YYYY-XX): ");
            numero = sc.nextLine();
        } while (!numero.matches("\\d{4}-\\d{2}"));

        System.out.print("Origen: ");
        origen = sc.nextLine();

        System.out.print("Destino: ");
        destino = sc.nextLine();

        do {
            System.out.print("Dia (dd-mm): ");
            dia = sc.nextLine();
        } while (!dia.matches("\\d{2}-\\d{2}"));

        do {
            System.out.print("Clase(Primera/Turista): ");
            clase = sc.nextLine();
        } while (!clase.equalsIgnoreCase("Primera") && !clase.equalsIgnoreCase("Turista"));

        if (clase.equalsIgnoreCase("Primera")) {
            vuelos.add(new Vuelos(numero, origen, destino, dia, Vuelos.Clase.PRIMERA));
        } else {
            vuelos.add(new Vuelos(numero, origen, destino, dia, Vuelos.Clase.TURISTA));
        }
        System.out.println("Vuelo añadido a la lista.");
    }

    public static void borrarVuelo() {
        System.out.println("Introduce número de vuelo para eliminarlo del registro");

        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos.");
            return;
        }

        System.out.print("Número de vuelo(YYYY-XX): ");
        String numero = sc.nextLine();


        boolean eliminado = vuelos.removeIf(vuelo ->
                vuelo.getNumero().equalsIgnoreCase(numero)
        );

        if (eliminado) {
            System.out.println("Vuelo nº " + numero + " eliminado.");
        } else {
            System.out.println("No existe un vuelo con ese número.");
        }
    }

    public static void main(String[] args) {
        boolean salir = false;
        int eleccion;
        vuelos.add(new Vuelos("2023-01", "Valencia", "Menorca", "15-08", Vuelos.Clase.TURISTA));
        vuelos.add(new Vuelos("2023-02", "Valencia", "Tenerife", "20-08", Vuelos.Clase.TURISTA));
        vuelos.add(new Vuelos("2023-03", "Paris", "Valencia", "15-08", Vuelos.Clase.PRIMERA));
        vuelos.add(new Vuelos("2023-04", "Atenas", "Valencia", "20-08", Vuelos.Clase.PRIMERA));


        while (!salir) {
            menu();
            System.out.println("Elige una opción:");
            try {
                eleccion = sc.nextInt();
                sc.nextLine();

                if (eleccion <= 0 || eleccion > 6) {
                    System.out.println("Opción no válida");
                    continue;
                }

                switch (eleccion) {
                    case 1 -> ImprimirVuelos();
                    case 2 -> {
                        System.out.println("Introduce el número de vuelo(Formato YYYY-XX)");
                        String numero = sc.nextLine();
                        buscarNumero(numero);
                    }
                    case 3 -> {
                        System.out.println("""
                                Introduce una de las claves para buscar el vuelo
                                (Origen,Destino,Día,Clase)
                                """);
                        String clave = sc.nextLine();
                        buscarClave(clave);
                    }
                    case 4 -> añadirVuelo();
                    case 5 -> borrarVuelo();
                    case 6 -> {
                        System.out.println("Saliendo...");
                        salir = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce los números que haya en el menú");
                sc.nextLine();
            }
        }
    }
}
