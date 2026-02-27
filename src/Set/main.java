package Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main {
    public static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {

        Planeta Mercurio = new Planeta("Mercurio", 88);
        Planeta Venus = new Planeta("Venus", 225);
        Planeta Tierra = new Planeta("Tierra", 365);
        Planeta Marte = new Planeta("Marte", 687);
        Planeta Jupiter = new Planeta("Jupiter", 4332);
        Planeta Saturno = new Planeta("Saturno", 10759);
        Planeta Urano = new Planeta("Urano", 30660);
        Planeta Neptuno = new Planeta("Neptuno", 165);
        Planeta Pluton = new Planeta("Pluton", 248);

        planetas.add(Mercurio);
        planetas.add(Venus);
        planetas.add(Tierra);
        planetas.add(Marte);
        planetas.add(Jupiter);
        planetas.add(Saturno);
        planetas.add(Urano);
        planetas.add(Neptuno);
        planetas.add(Pluton);

        sistemaSolar.put("Mercurio", Mercurio);
        sistemaSolar.put("Venus", Venus);
        sistemaSolar.put("Tierra", Tierra);
        sistemaSolar.put("Marte", Marte);
        sistemaSolar.put("Jupiter", Jupiter);
        sistemaSolar.put("Saturno", Saturno);
        sistemaSolar.put("Urano", Urano);
        sistemaSolar.put("Neptuno", Neptuno);
        sistemaSolar.put("Pluton", Pluton);

        Luna Luna = new Luna("Luna", 27);
        Tierra.addSatelite(Luna);

        Luna Deimos = new Luna("Deimos", 1.3);
        Luna Phobos = new Luna("Phobos", 0.3);

        Marte.addSatelite(Deimos);
        Marte.addSatelite(Phobos);

        Luna Io = new Luna("Io", 1.8);
        Luna Europa = new Luna("Europa", 3.5);
        Luna Ganymedes = new Luna("Ganymedes", 7.1);
        Luna Callisto = new Luna("Callisto", 16.7);

        System.out.println();
        System.out.println("PLANETAS");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta);
        }
        System.out.println();
        System.out.println("MARTE Y SUS LUNAS");

        System.out.println(sistemaSolar.get("Marte"));
        for (CuerpoCeleste luna : Marte.getSatelites()) {
            System.out.println(luna);
        }
        //Crear set de lunas
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste planeta : sistemaSolar.values()) {
            lunas.addAll(planeta.getSatelites());
        }
        System.out.println();
        System.out.println("LUNAS DEL SISTEMA");
        for (CuerpoCeleste luna : lunas) {
            System.out.println(luna);
        }

        //No se agrega porque ya existe un Planeta pluton, necesito darle otro nombre a la variable
        //Pluton2, no se añade al set porque ya existe pluton
        Planeta Pluton2 = new Planeta("Pluton", 884);
        //Si lo haces planeta enano la varialble la podemos llamar Pluton3 y si que nos deja
        PlanetaEnano Pluton3 = new PlanetaEnano("Pluton", 884);

        System.out.println();
        System.out.println("INTERSECCIONES");
        Set<CuerpoCeleste> lunasTierra = new HashSet<>();
        lunasTierra.add(Luna);

        Set<CuerpoCeleste> lunasMarte = new HashSet<>();
        lunasMarte.add(Phobos);
        lunasMarte.add(Deimos);

        Set<CuerpoCeleste> interseccion = new HashSet<>(lunasTierra);
        interseccion.retainAll(lunasMarte);
        for (CuerpoCeleste luna : interseccion) {
            System.out.println(luna);
        }

        //No enseña nada la interseccion porque Tierra y Marte no tienen objetos en común
        // si le añado el satelite Luna a Marte veremos que ocurre
        System.out.println("Añadimos Luna a Satelites de Marte, ahora tanto tierra y marte tienen satelite Luna" +
                "y lo imprimimos con un for each");
        lunasMarte.add(Luna);
        interseccion.addAll(lunasTierra);
        interseccion.retainAll(lunasMarte);

        for (CuerpoCeleste luna : interseccion) {
            System.out.println(luna);
        }
        System.out.println("DIFERENCIAS");
        //En este caso tenemos TIERRA -> LUNA MARTE -> LUNA,DEIMOS Y PHOBOS, ALL HACER EL REMOVEALL deberia dejar las lunas de Marte
        Set<CuerpoCeleste> diferencia = new HashSet<>(lunasMarte);
        diferencia.removeAll(lunasTierra);
        for (CuerpoCeleste luna : interseccion) {
            System.out.println(luna);
        }
    }
}
