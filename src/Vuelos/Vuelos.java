package Vuelos;

import java.util.ArrayList;

public class Vuelos {
    private String numero;
    private String origen;
    private String destino;
    private String dia;
    private Clase Clase;
    private ArrayList<Vuelos> conexiones;

    // Constructor
    Vuelos(String numero, String origen, String destino, String dia, Clase tipo) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.Clase = tipo;
        this.conexiones = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDia() {
        return dia;
    }

    public Clase getClase() {
        return Clase;
    }

    public ArrayList<Vuelos> getConexiones() {
        return conexiones;
    }

    @Override
    public String toString() {
        return "Vuelo " +
                "numero='" + numero + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", dia='" + dia + '\'' +
                ", clase=" + Clase;
    }

    public enum Clase {PRIMERA, TURISTA}
}
