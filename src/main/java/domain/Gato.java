package domain;

public class Gato {
    private String nombre;
    private Color color;
    private int energia;
    private int hambre;
    private int diversion;
    private double temperaturaCorporal;
    private Prenda prenda;
    private Punto punto;

    public Gato(String nombre, Color color){
        this.nombre = nombre;
        this.color = color;
        this.energia = 10;
        this.hambre = 10;
        this.diversion = 0;
        this.temperaturaCorporal = 37.0;
        this.prenda = null;
        this.punto = new Punto(0,0);
    }

    public int getEnergia() {
        return energia;
    }

    public Punto posicionActual(){
        return this.punto;
    }

    public int getHambre() {
        return hambre;
    }

    public int getDiversion() {
        return diversion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void disminuirEnergiaEn(int algunasUnidades){
        this.energia -= algunasUnidades;
    }

    public void disminuirHambreEn(int algunasUnidades){
        this.hambre -= algunasUnidades;
    }

    public void aumentarDiversionEn(int algunasUnidades){
        this.diversion += algunasUnidades;
    }

    public void aumentarTemperaturaEn(double algunosGrados){
        this.temperaturaCorporal += algunosGrados;
    }

    public void aumentarHambreEn(int algunasUnidades){
        this.hambre += algunasUnidades;
    }

    public void disminuirTemperaturaEn(double algunosGrados){
        this.temperaturaCorporal -= algunosGrados;
    }

    public void jugaCon(Jugable jugable){
        jugable.jugarCon(this);
    }

    public void come(int algunasRaciones, Comida comida){
        comida.afectarHambreDe(this, algunasRaciones);
    }

    public void dormi(int unosMinutos){
        this.energia += 2 * (unosMinutos/30);
    }

    public void camina(int unosMetros){
        disminuirEnergiaEn(unosMetros/70);
        aumentarHambreEn(2 * (unosMetros/40));
    }

    public void caminaHacia(Lugar unLugar){
        Punto ubicacionDelLugar = unLugar.getPunto();
        camina(ubicacionDelLugar.distanciaAbsolutaEntre(this.punto));
        this.punto = ubicacionDelLugar;
        unLugar.serVisitadoPor(this);
    }

    public void abrigateCon(Prenda unaPrenda){
        this.prenda = unaPrenda;
        unaPrenda.abrigarA(this);
    }

    public void sacateElAbrigo(){
        if(this.prenda != null){
            this.prenda.quitateDe(this);
        }
    }
}
