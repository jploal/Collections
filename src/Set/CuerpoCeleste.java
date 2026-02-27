package Set;

import java.util.HashSet;
import java.util.Set;

public abstract class CuerpoCeleste {
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpoCeleste;

    CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpoCeleste = tipo;
        this.satelites = new HashSet<>();
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public TipoCuerpoCeleste getTipoCuerpoCeleste() {
        return tipoCuerpoCeleste;
    }

    public boolean addSatelite(CuerpoCeleste c) {
        if (satelites.contains(c)) {
            System.out.println("Ese cuerpo en concreto ya existe");
            return false;
        }
        satelites.add(c);
        System.out.println("Cuerpo celeste añadido con exito");
        return true;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if ((a == null) || (getClass() != a.getClass())) return false;
        CuerpoCeleste c = (CuerpoCeleste) a;
        return this.nombre.equals(c.getNombre()) && this.tipoCuerpoCeleste == (c.getTipoCuerpoCeleste());
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + tipoCuerpoCeleste.hashCode();
        return result;
    }

    public String toString() {
        return this.nombre + ":" + this.tipoCuerpoCeleste + "," + this.periodoOrbital;
    }

    public enum TipoCuerpoCeleste {ESTRELLA, PLANETA_ENANO, PLANETA, LUNA, COMETA, ASTEROIDE}
}
