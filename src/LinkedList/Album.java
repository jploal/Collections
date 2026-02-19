package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }
    public Cancion findSong(String nombre) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equals(nombre)){
                return cancion;
            }
        }
        return null;
    }
    public boolean addSong(String titulo, Double duracion) {
        if (findSong(titulo)==null){
            canciones.add(new Cancion(titulo,duracion));
            System.out.println("La canción se agrego con éxito");
            return true;
        }
        System.out.println("La canción ya existe en el sistema");
        return false;
    }
    public boolean addToPlayList(int numero, LinkedList<Cancion> playList) {
        int index = numero - 1;

        if (index >= 0 && index < this.canciones.size()) {
            playList.add(this.canciones.get(index));
            return true;
        }

        System.out.println("Número de pista no válido");
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList) {

        Cancion cancionEncontrada = findSong(titulo);

        if (cancionEncontrada != null) {
            playList.add(cancionEncontrada);
            return true;
        }

        System.out.println("La canción no existe en el álbum");
        return false;
    }

}
