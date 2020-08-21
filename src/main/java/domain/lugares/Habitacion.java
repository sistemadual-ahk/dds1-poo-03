package domain.lugares;

import domain.mascotas.Gato;

public class Habitacion extends Lugar {
    private int desorden;

    public Habitacion(Punto punto) {
        super(punto);
        this.desorden = 0;
    }

    public int getDesorden() {
        return desorden;
    }

    @Override
    public void serVisitadoPor(Gato unGato){
        this.desorden++;
    }
}
