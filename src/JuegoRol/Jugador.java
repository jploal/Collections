package JuegoRol;

import java.util.ArrayList;

public class Jugador {
    public enum Clase {CABALLERO,INVENTOR,MAGO,CLERIGO,PALADÍN,GUERRERO,HECHICERO,BRUJO,SABIO,EXPLORADOR}
    private String Nombre;
    private Clase Tipo;
    private ArrayList<String> Mochila;
    private int PS;

    public String getNombre() {
        return Nombre;
    }

    public Clase getTipo() {
        return Tipo;
    }

    public ArrayList<String> getMochila() {
        return Mochila;
    }

    public int getPS() {
        return PS;
    }

    Jugador(String Nombre, Clase Tipo, int PS) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.PS = PS;
        this.Mochila=new  ArrayList<>();
    }
    public void guardar(String objeto) {
        Mochila.add(objeto);
    }

    @Override
    public String toString() {
        return this.Nombre + "-"+ this.Tipo +"-"+this.Mochila.toString() +"-"+ this.PS;
    }
    public void sumarVida(int cantidad) {
        this.PS += cantidad;
    }
}
