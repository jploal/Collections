package LinkedList;

public class Cancion {
    private String titulo;
    private Double duracion;

    Cancion(String titulo, Double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + ": " + duracion;
    }

}
