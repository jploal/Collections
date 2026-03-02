package JuegoRol;

import java.util.ArrayList;

public class Lista {

    private ArrayList<Jugador> jugadores;

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Lista() {
        jugadores = new ArrayList<>();
    }
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }


    public  void mostrarJugadores() {
        for (Jugador j : jugadores) {
            System.out.println(j);
        }
    }
    public Jugador buscarPorNombre(String nombre) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }
}
