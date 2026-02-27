package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public Main() {

        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));


        //Montaña (1)
        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("O", 2);
        ubicaciones.get(1).addExit("E", 3);

        // Playa (2)
        ubicaciones.get(2).addExit("N", 5);

        // Edificio (3)
        ubicaciones.get(3).addExit("O", 1);

        // Puente (4)
        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);

        // Bosque (5)
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);
    }

    public static void main(String[] args) {

        Main juego = new Main();
        Scanner sc = new Scanner(System.in);

        int actual = 1;
        boolean salir = false;
        System.out.println(juego.ubicaciones.get(actual).getDescription());

        while (!salir) {

            System.out.print("Se puede viajar hacia:");
            for (String direccion : juego.ubicaciones.get(actual).getExits().keySet()) {
                System.out.print(direccion + " ");
            }
            System.out.println();

            System.out.print("Destino: ");
            String respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("Q")) {
                System.out.println("Saliendo del juego...");
                salir = true;
            }

            if (juego.ubicaciones.get(actual).getExits().containsKey(respuesta)) {

                int siguiente = juego.ubicaciones.get(actual).getExits().get(respuesta);

                if (juego.ubicaciones.containsKey(siguiente)) {
                    actual = siguiente;
                    System.out.println(juego.ubicaciones.get(actual).getDescription());
                } else {
                    System.out.println("No puedes ir a ese lugar.");
                }

            } else {
                System.out.println("No puedes ir en esa dirección");
            }
        }
    }
}
