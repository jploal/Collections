package LinkedList;

import java.util.*;

public class main {

    private static Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        System.out.println("""
                0 – Salir
                1 – Siguiente canción
                2 – Canción anterior
                3 – Repetir canción
                4 – Imprimir playlist
                5 – Mostrar menú
                6 – Eliminar canción actual
                """);
    }

    public static void printList(LinkedList<Cancion> playlist) {
        Iterator<Cancion> iterator = playlist.iterator();
        System.out.println("Lista de reproducción:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void play(LinkedList<Cancion> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        boolean siguiente = true;

        ListIterator<Cancion> iterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("Playlist vacía");
            return;
        } else {
            System.out.println("Reproduciendo: " + iterator.next());
        }


        while (!salir) {
            Menu();
            try {
                System.out.println("Elige una opción:");
                int action = scanner.nextInt();

                switch (action) {

                    case 0 -> {
                        System.out.println("Saliendo de la playlist...");
                        salir = true;
                    }

                    case 1 -> {
                        if (!siguiente) {
                            if (iterator.hasNext()) iterator.next();
                            siguiente = true;
                        }
                        if (iterator.hasNext()) {
                            System.out.println("Reproduciendo: " + iterator.next());
                        } else {
                            System.out.println("Final de la playlist");
                            siguiente = false;
                        }
                    }

                    case 2 -> {
                        if (siguiente) {
                            if (iterator.hasPrevious()) iterator.previous();
                            siguiente = false;
                        }
                        if (iterator.hasPrevious()) {
                            System.out.println("Reproduciendo: " + iterator.previous());
                        } else {
                            System.out.println("Inicio de la playlist");
                            siguiente = true;
                        }
                    }

                    case 3 -> {
                        if (siguiente) {
                            if (iterator.hasPrevious()) {
                                System.out.println("Repitiendo: " + iterator.previous());
                                siguiente = false;
                            }
                        } else {
                            if (iterator.hasNext()) {
                                System.out.println("Repitiendo: " + iterator.next());
                                siguiente = true;
                            }
                        }
                    }

                    case 4 -> printList(playlist);

                    case 5 -> Menu();

                    case 6 -> {
                        if (playlist.size() > 0) {
                            iterator.remove();
                            if (iterator.hasNext()) {
                                System.out.println("Reproduciendo: " + iterator.next());
                            } else if (iterator.hasPrevious()) {
                                System.out.println("Reproduciendo: " + iterator.previous());
                            }
                        }
                    }

                    default -> System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce valores de la lista, solo numericos.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

        Album album1 = new Album("Divide", "Ed Sheeran");
        album1.addSong("Shape of You", 4.24);
        album1.addSong("Perfect", 4.40);
        album1.addSong("Galway Girl", 2.50);
        album1.addSong("Photograph", 4.17);

        Album album2 = new Album("Thriller", "Michael Jackson");
        album2.addSong("Thriller", 5.57);
        album2.addSong("Beat It", 4.18);
        album2.addSong("Billie Jean", 4.54);
        album2.addSong("Smooth Criminal", 4.17);

        albums.add(album1);
        albums.add(album2);

        LinkedList<Cancion> playlist = new LinkedList<>();

        album1.addToPlayList(1, playlist);
        album1.addToPlayList(2, playlist);
        album1.addToPlayList(3, playlist);
        album1.addToPlayList(4, playlist);

        album2.addToPlayList("Thriller", playlist);
        album2.addToPlayList("Billie Jean", playlist);
        album2.addToPlayList("Beat It", playlist);
        album2.addToPlayList("Smooth Criminal", playlist);

        printList(playlist);
        play(playlist);

    }
}

