package domain;

import domain.juguetes.Juguete;
import domain.lugares.*;
import domain.mascotas.Color;
import domain.mascotas.Gato;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GatoTest {
    private Gato gary;

    @Before
    public void init(){
        this.gary = new Gato("Gary", Color.NARANJA);
    }

    @Test
    public void colorDeGaryEsNaranjaTest(){
        Assert.assertEquals(Color.NARANJA, this.gary.getColor());
    }

    @Test
    public void abrigarConBusoLevantaTemperaturaTest(){
        Prenda unBuzo = new Prenda(0.5);
        this.gary.abrigateCon(unBuzo);

        Assert.assertEquals(37.5, gary.getTemperaturaCorporal(), 0.0);
    }

    @Test
    public void jugarConRatonTest(){
        Juguete unRaton = new Juguete(10);
        this.gary.jugaCon(unRaton);

        Assert.assertEquals(10, this.gary.getDiversion());
    }

    @Test
    public void jugarConPersonaTest(){
        Persona eze = new Persona("Eze");
        this.gary.jugaCon(eze);

        Assert.assertEquals(15, this.gary.getDiversion());
        Assert.assertEquals(8, this.gary.getEnergia());
    }

    @Test
    public void comerCesoDisminuyeHambreTest(){
        Comida ceso = new Comida(2);
        this.gary.come(1, ceso);

        Assert.assertEquals(8, this.gary.getHambre());
    }

    @Test
    public void caminarHaciaLaCasaDelVecinoTest(){
        Lugar casaDePepe = new CasaDelVecino(new Punto(180,5));
        this.gary.caminaHacia(casaDePepe);

        Assert.assertEquals(8, this.gary.getEnergia());
        Assert.assertEquals(casaDePepe.getPunto(), this.gary.posicionActual());
    }

    @Test
    public void caminarHaciaCocinaAumentaPelosTest(){
        Cocina cocina = new Cocina(new Punto(4,30));
        this.gary.caminaHacia(cocina);

        Assert.assertEquals(2, cocina.getCantidadDePelos());
    }

    @Test
    public void caminarHaciaHabitacionAumentaDesordenTest(){
        Habitacion unaHabitacion = new Habitacion(new Punto(14,10));
        this.gary.caminaHacia(unaHabitacion);

        Gato negri = new Gato("Negri", Color.NEGRO);
        negri.caminaHacia(unaHabitacion);

        Gato ciro = new Gato("Ciro", Color.NARANJA);
        ciro.caminaHacia(unaHabitacion);

        Assert.assertEquals(3,unaHabitacion.getDesorden());
    }
}
