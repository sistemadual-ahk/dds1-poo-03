package domain.juguetes;

import domain.mascotas.Gato;

public class Juguete implements Jugable {
    private int nivelDeDiversion;

    public Juguete(int nivelDeDiversion){
        this.nivelDeDiversion = nivelDeDiversion;
    }

    @Override
    public void jugarCon(Gato unGato){
        unGato.aumentarDiversionEn(this.nivelDeDiversion);
    }
}
