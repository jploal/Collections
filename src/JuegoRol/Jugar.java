package JuegoRol;

import java.util.List;
import java.util.Scanner;

    public class Jugar {

        public static void jugar(Scanner sc, Lista lista, Jugador jugadorActual) {

            boolean existe2 = false;
            Jugador jugador2 = null;

            // jugador 2
            while (!existe2) {
                System.out.println("Introduce nombre de jugador 2");
                String otro = sc.nextLine();

                jugador2 = lista.buscarPorNombre(otro);

                if (jugador2 == null) {
                    System.out.println("Jugador no existe.");
                } else if (jugador2 == jugadorActual) {
                    System.out.println("No puedes jugar contra ti mismo.");
                } else {
                    existe2 = true;
                    System.out.println(jugadorActual.getNombre() + " VS " + jugador2.getNombre());
                }
            }

            int victorias1 = 0;
            int victorias2 = 0;

            // rondas
            while (victorias1 < 2 && victorias2 < 2) {

                System.out.println("\n--- NUEVA RONDA ---");

                // Generar valores aleatorios únicos para cada jugador
                List<Integer> valores1 = generarValores(jugadorActual.getMochila().size());
                List<Integer> valores2 = generarValores(jugador2.getMochila().size());

                System.out.println(jugadorActual.getNombre() + ": " + jugadorActual.getMochila());
                System.out.println(jugador2.getNombre() + ": " + jugador2.getMochila());

                // herramientas
                System.out.println("Elige herramienta:");
                String h1 = sc.nextLine();

                System.out.println("Turno de " + jugador2.getNombre());
                String h2 = sc.nextLine();

                // validar
                if (!jugadorActual.getMochila().contains(h1) || !jugador2.getMochila().contains(h2)) {
                    System.out.println("Herramienta inválida. Intenta de nuevo.");
                    continue;
                }

                // Sacar el valor de la herramienta
                int indice1 = jugadorActual.getMochila().indexOf(h1);
                int indice2 = jugador2.getMochila().indexOf(h2);

                int valor1 = valores1.get(indice1);
                int valor2 = valores2.get(indice2);

                System.out.println(h1 + " valor: " + valor1);
                System.out.println(h2 + " valor: " + valor2);

                // Comparar
                if (valor1 > valor2) {
                    System.out.println("Gana ronda " + jugadorActual.getNombre());
                    victorias1++;
                } else if (valor2 > valor1) {
                    System.out.println("Gana ronda " + jugador2.getNombre());
                    victorias2++;
                } else {
                    System.out.println("Empate");
                }
            }

            // Ganador final
            if (victorias1 == 2) {
                System.out.println("GANADOR FINAL: " + jugadorActual.getNombre());
                jugadorActual.sumarVida(10);
            } else {
                System.out.println("GANADOR FINAL: " + jugador2.getNombre());
                jugador2.sumarVida(10);
            }
        }

        // Genera lista de valores únicos del 1 al tamaño
        public static List<Integer> generarValores(int cantidad) {
            List<Integer> valores = new java.util.ArrayList<>();
            for (int i = 1; i <= cantidad; i++) {
                valores.add(i);
            }
            java.util.Collections.shuffle(valores);
            return valores;
        }
    }
    //USANDO RANDOM
    //Random r = new Random();
    //
    //int tamaño = jugadorActual.getMochila().size();
    //int[] valores = new int[tamaño];
    //boolean[] usado = new boolean[tamaño + 1]; // posiciones 1 a n
    //
    //for (int i = 0; i < tamaño; i++) {
    //
    //    int numero;
    //
    //    do {
    //        numero = r.nextInt(tamaño) + 1;  // 1 a tamaño
    //    } while (usado[numero]);
    //
    //    valores[i] = numero;
    //    usado[numero] = true;
    //}
