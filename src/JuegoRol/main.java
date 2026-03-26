package JuegoRol;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void menu() {
        System.out.println("""
                =================================
                JUEGO DE ROL
                =================================
                1 - Recuento de Personajes
                2 - Imprime tus datos
                3 - Jugar
                4 - Salir del programa
                ---------------------------------
                """);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir=false;
        boolean existe=false;
        Jugador jugadorActual = null;
        String inicial= null;

        Jugador p1 = new Jugador("Sergio", Jugador.Clase.INVENTOR, 90);
        p1.guardar("fórmula");
        p1.guardar("microscopio");
        p1.guardar("microorganismo");
        p1.guardar("autómata");

        Jugador p2 = new Jugador("Mara", Jugador.Clase.GUERRERO, 80);
        p2.guardar("escudo");
        p2.guardar("ballesta");
        p2.guardar("hacha");
        p2.guardar("unicornio");

        Jugador p3 = new Jugador("Miquel", Jugador.Clase.EXPLORADOR, 85);
        p3.guardar("lupa");
        p3.guardar("escoba");
        p3.guardar("dragón");
        p3.guardar("brújula");

        Jugador p4 = new Jugador("Claudia", Jugador.Clase.MAGO, 110);
        p4.guardar("varita");
        p4.guardar("hechizo");
        p4.guardar("libro");
        p4.guardar("gata");

        Jugador p5 = new Jugador("Carlos", Jugador.Clase.SABIO, 95);
        p5.guardar("varita");
        p5.guardar("conjuro");
        p5.guardar("sombrero");
        p5.guardar("búho");

        Jugador p6 = new Jugador("Alexia", Jugador.Clase.EXPLORADOR, 100);
        p6.guardar("látigo");
        p6.guardar("semillas");
        p6.guardar("hacha");
        p6.guardar("yegua");

        Lista lista = new Lista();
        lista.agregarJugador(p1);
        lista.agregarJugador(p2);
        lista.agregarJugador(p3);
        lista.agregarJugador(p4);
        lista.agregarJugador(p5);
        lista.agregarJugador(p6);

        while (!existe) {
            System.out.println("Introduce tu nombre de jugador");
            inicial = sc.nextLine();

            jugadorActual = lista.buscarPorNombre(inicial);

            if (jugadorActual == null) {
                System.out.println("No existe el jugador");
            } else {
                System.out.println("Jugador encontrado, bienvenido " + inicial);
                existe = true;
            }
        }
        while (!salir) {
            menu();
            System.out.println("Elige una opción:");
            try {
                int eleccion = sc.nextInt();
                sc.nextLine();

                if (eleccion < 1 || eleccion > 4) {
                    System.out.println("Opción no válida");
                    continue;
                }

                switch (eleccion) {
                    case 1 ->lista.mostrarJugadores();
                    case 2 ->System.out.println(jugadorActual.toString());
                    case 3 -> Jugar.jugar(sc, lista, jugadorActual);
                    case 4 ->salir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce los números que haya en el menú");
                sc.nextLine();
            }
        }
        System.out.println("Saliendo...");
    }
    }
