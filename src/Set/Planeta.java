package Set;

public class Planeta extends CuerpoCeleste {
    Planeta(String nombre, double periodo) {
        super(nombre, periodo, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste c) {
        if (c instanceof Luna || c.getTipoCuerpoCeleste().equals(TipoCuerpoCeleste.LUNA)) {
            System.out.println("Luna Orbitando");
            return super.addSatelite(c);
        }
        System.out.println("Ese cuerpo celeste no puede ser satélite, asegurate de que sea una Luna");
        return false;
    }
}
