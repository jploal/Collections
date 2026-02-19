package LinkedList;

public class Cancion {
    private String titulo;
    private Double duracion;

    public String getTitulo() {
        return titulo;
    }

    Cancion(String titulo, Double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + ": " + duracion;
    }

}
