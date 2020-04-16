#  Tercer módulo - Paradigma Orientado a Objetos
**Índice**
- [Paradigma orientado a Objetos](#paradigma-orientado-a-objetos)
    - [Clase](#clase)
	- [Instancias](#instancias)
	- [Clase abstracta](#clase-abstracta)
    - [Polimorfismo](#polimorfismo)
- [Generalizando a Gary](#generalizando-a-gary)
    - [Séptima iteración](#séptima-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Java
	- [Octava iteración](#octava-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Java
	- [Novena iteración](#novena-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Java
	- [Décima iteración](#décima-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Java

### Paradigma Orientado a Objetos
#### Clase
¿Qué sucede si muchos de mis objetos de dominio se comportan igual y tienen características iguales? Probablemente estemos repitiendo exactamente el mismo código y/o la misma lógica en todos los objetos.
Una forma de evitar esto es crear moldes para nuestros objetos,  o más conocido como Clases.
Las clases nos permiten definir moldes para nuestros objetos, para que todos ellos se comporten de la misma manera.
¿Qué es lo que queremos que compartan nuestros objetos? Pensemos en, por ejemplo, Gary. ¿Qué es Gary? Es un Gato. ¿Qué hace Gary? Duerme, come, camina, juega, etc. ¿Todos los gatos lo hacen? Sí. Si generalizamos y generamos una nueva abstracción, deberíamos pensar en modelar a un Gato.  Todos los gatos duermen, comen, caminan, juegan, etc. Todos los gatos tienen un color, un nombre, entre otras cosas. ¿Qué estamos pensando y modelando? El molde de un Gato. Gary sería un caso particular de ese molde. 
Gráficamente podríamos decir que una clase es el contorno de la figura y un objeto es el relleno de ese contorno.
Si modelamos la clase Gato ya no solamente podremos tener a Gary, sino que también a todos los gatos que se nos ocurran.
Por último, diremos que una clase es una forma de clasificar a los objetos que "se parecen". Los objetos que responden a los mismos mensajes de igual
manera y que tienen una estructura interna igual (los mismos atributos, con
diferente valor para cada objeto), se clasifican juntos en una determinada "clase". 

#### Instancias
Hemos dicho que las clases son los moldes de los objetos, pero la gran pregunta es: ¿cómo obtengo un objeto a partir de una clase? 
Al proceso de crear un objeto a partir de una clase se lo conoce como **instanciación** y decimos que el objeto obtenido como resultado de este proceso es una instancia de esa clase.
Entonces, de forma resumida, podríamos decir que un objeto es una instancia de una clase.

¿Pero cómo se hace? Instanciemos, por ejemplo, a Gary. Gary será una instancia de la clase Gato:`Gato gary = new Gato();` 
Esta sentencia es válida en Java, pero la realidad es que en muchos lenguajes también se usa la palabra `new` para pedir una instancia de una clase.

#### Clase abstracta
Una clase abstracta es una clase que no puede ser instanciada. Decimos que las clases abstractas tienen clases hijas, o bien que algunas clases herendan de ella.  Estas clases, las hijas, sí pueden ser instanciadas siempre y cuando sean concretas. Una clase es concreta cuando no es abstracta.

¿Para qué sirven? Así como evitamos repetir código y lógica entre los objetos cuando muchos de ellos tenían el mismo comportamiento generando clases, ahora podemos evitar repetir código y lógica entre clases haciéndolas heredar de una clase abstracta en común. En las clases abstractas podemos escribir el código en común que tengan muchas clases, ya sea métodos o atributos.

Por ejemplo, supongamos que queremos modelar a un Gato que puede comer y a un Perro que también puede hacerlo. Sabemos que cuando comen, ambos animales disminuyen su nivel de hambre. ¡Hemos detectado un comportamiento en común! Podríamos crear una clase abstracta Animal que entienda el mensaje `come()` y luego tener a la clase Gato y Perro que hereden de ella.  

Es importante tener en cuenta que en la mayoría de los lenguajes solo se soporta la herencia simple. Se dice que un lenguaje soporta herencia simple cuando solamente permite que una clase herede de una sola clase, es decir, permite que una clase tenga como máximo un padre. Java es uno de estos lenguajes.
La realidad es que en otros lenguajes, como Python, se soporta la herencia múltiple. Que un lenguaje soporte la herencia múltiple significa que permite que una clase tenga muchos padres. Pero esto último, la herencia múltiple, no nos tiene que gustar y no la vamos a anhelar.

#### Polimorfismo
Es una característica que nos permite trabajar con objetos distintos en forma transparente.
Decimos que dos o más objetos son polimórficos para un tercero si éste puede trabajar indistintamente con cualquiera de ellos. 
Una forma distinta de definir el polimorfismo es decir que dos o más objetos son polimórficos si entienden los mismos mensajes. 
Lo cierto es que dependiendo del tipo de lenguaje en el que estemos programando veremos este concepto de forma diferente. Por ejemplo, sabemos que Java es un lenguaje de fuertemente tipado y, por lo tanto, debemos definir el tipo de cada parámetro en un método. ¿Cómo hacemos para definir un tipo y aplicar el concepto de polimorfismo si lo que puedo recibir son muchos objetos distintos? Una estrategia podría ser definir una interface y hacer que varias clases implementen la misma. Para el método en cuestión, será transparente recibir cualquier objeto, siempre y cuándo cumplan con dicha interface.

No le habíamos puesto nombre, pero este concepto ya lo habíamos aplicado para resolver el dominio de Gary. En particular, lo aplicamos con los juguetes, las comidas y los lugares que podía visitar.

## Generalizando a Gary
### Séptima iteración
#### Dominio
Detectamos que el mismo comportamiento que tiene Gary también lo tienen muchos otros gatos más. Queremos evitar repetir código y lógica y es por eso que se deberá generalizar la abstracción de este gato.
En esta iteración solo se deberá poder preguntarle a un gato:
- Cuál es su nombre
- Cuál es su color
- En cuánto quedó su energía luego de dormir unos minutos
- En cuánto quedó su hambre y su energía luego de mandarlo a caminar unos metros (sin importar el lugar)

#### Diseño en objetos
Como sabemos que muchos gatos van a tener el mismo comportamiento, vamos a generar una nueva y más abarcativa abstracción: la clase Gato.
Pondremos como atributo el nombre, el color, la energía y el hambre.
El nombre del gato lo podemos modelar como un simple `string`, porque es una mera "etiqueta" para nuestros gatos.
Para la energía y el hambre vamos a optar por modelarlos como `int`, porque por el momento nos basta.
¿Pero qué sucede con el color? Si lo modelamos como un string le estamos dando la posibilidad, a la persona que instancie un gato, de setearle un valor inconsistente. ¿Qué es esto? 
Supongamos que tenemos tres gatos: a Gary, de color naranja, a Negri, de color negro, y a Ciro, también de color naranja.

```java
Gato gary = new Gato();
Gato negri = new Gato();
Gato ciro = new Gato();
```
Y que el programador que los está instanciando hace lo siguiente:

```java
gary.setColor("Naranja");
negri.setColor("Negro");
ciro.setColor("anaranjado");
```
¿Qué acaba de pasar? El programador está utilizando dos palabras diferentes para expresar el mismo color. Esto podría generar inconsistencias de datos y traer complicaciones si la aplicación crece.
Para solucionar este problema utilizaremos un Enum llamado `Color`

¡Todo listo!
#### Implementación
Creemos la clase Gato. ¡Ah! Desde ahora solamente trabajaremos en Java.
```java
public class Gato {
    private String nombre;
    private int energia;
    private int hambre;

    public int getEnergia() {
        return energia;
    }

    public int getHambre() {
        return hambre;
    }

    public String getNombre() {
        return nombre;
    }
	
	public void disminuirEnergiaEn(int algunasUnidades){
        this.energia -= algunasUnidades;
    }
	
	public void aumentarHambreEn(int algunasUnidades){
        this.hambre += algunasUnidades;
    }
	
	public void dormi(int unosMinutos){
        this.energia += 2 * (unosMinutos/30);
    }
	
	public void camina(int unosMetros){
        disminuirEnergiaEn(unosMetros/70);
        aumentarHambreEn(2 * (unosMetros/40));
    }

}

```
Cosas para recordar de la sintaxis de Java:
- Para definir una clase debemos escribir `public class NombreDeMiClase { ...}`
- -Casi- Todas las sentencias terminan con `;` de forma obligatoria
- No es obligatorio inicializar los atributos en el momento de su declaración. Esto quiere decir que pueden ir de la forma en que lo acabamos de hacer, o bien de la siguiente forma: `accessor TipoDeDato miReferencia = unValorPosible;`
- Los métodos no llevan palabras extras para su declaración (como sí pasaba en Kotlin que teníamos que escribir la palabra `fun`). De forma genérica: `accessor TipoRetorno nombreDelMetodo(){ .... }`
- Los parámetros que se reciben en los métodos deben ser obligatoriamente tipados. Genéricamente: `accessor TipoRetorno nombreDelMetodo(TipoParametro1 parametro1, TipoParametro2 parametro2, ... ){ .... }`

Cosas que están buenas por convención:
- Las nombres de las clases deben comenzar con mayúscula
- Los nombres de los métodos y de las variables deben ser escritos en[ lower camel case](https://es.wikipedia.org/wiki/Camel_case " lower camel case").

Retomando con la implementación, ¿nos olvidamos los setters? ¡No! Vamos a exigir que algunos atributos sean obligatorios para poder instanciar a un Gato. Para hacer esto necesitamos definir un **constructor**. El constructor es el método que se llama cuando se hace un *new*, pero a diferencia de todos los métodos, no se especifica el tipo de retorno. Veamos:

```java
public class Gato {
    private String nombre;
    private int energia;
    private int hambre;

	public Gato(String nombre){
        this.nombre = nombre;
        this.energia = 10;
        this.hambre = 10;
    }
}

```
Algo más por convención:
- Si los atributos necesitan ser inicializados, debemos hacerlo dentro del constructor y no al momento de la declaración.

Ahora vamos a crear el Color:
```java
public enum Color {
    MARRON,
    NEGRO,
    BLANCO,
    NARANJA
}
```
Lo cierto es que podemos poner todos los colores que se nos dé la gana, pero con esos vamos a estar bien para este dominio.
Agreguemos el color a la clase Gato y forcemos a que le llegue uno de ellos en el constructor.
```java
public class Gato {
    private String nombre;
	private Color color;
    private int energia;
    private int hambre;
	
	public Gato(String nombre, Color color){
        this.nombre = nombre;
        this.energia = 10;
        this.hambre = 10;
		this.color = color;
    }
}
```
#### Tests
##### En Java
Como ya hemos probado que el comportamiento de Gary funcionaba, asumimos que también funcionará la lógica de la clase Gato ya que por el momento no hemos hechos cambios en los métodos.
Solamente veremos como hacer cada test atómico, es decir, que no dependa uno del otro. Para ello vamos a necesitar especificar un método `init()` junto con la anotación `@Before`, la cual indica que siempre debe ejecutarse este método antes de ejecutar algún método anotado como test (`@Test`).
```java
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
}
```
Lo cierto es que el método `init()` puede llamarse como uno quiera.
Además, prestemos atención a un detalle no menor: los tests están escritos en una clase y como toda clase, puede tener atributos. Por este motivo, nuestra clase de testeo tiene como atributo a un gato, en particular, a un objeto que representará a Gary.
### Octava iteración
#### Dominio
Hemos detectado, también, que repetimos lógica al modelar las comidas y las prendas. Lo cierto es que cualquier gato podría comer las comidas que come Gary y usar las prendas que usa Gary.
En esta iteración se deberá poder decirle a un gato:
- Que se abrigue con alguna prenda
- Que coma algunas raciones de alguna comida

#### Diseño en objetos
Sabemos exactamente a donde queremos llegar, ¿no?
- `manchas.abrigateCon(unaCamisa)` suponiendo que `manchas` es un objeto de tipo Gato y que `unaCamisa` es una prenda.
- `manchas.come(2, unPedazoDeCarne)` suponiendo que `unPedazoDeCarne` es una comida.

Todas las prendas tienen algo en común y es el nivel de abrigo. Si recordamos las prendas que usaba Gary, todas afectaban su temperatura corporal en mayor o menor medida. ¿Por qué no generalizar el concepto? Tranquilamente `capa`, `buso` o `chaquetaDeJean` pueden ser instancias de una clase Prenda. Entonces, si pensamos en la abstracción Prenda como clase, un atributo de la misma será `nivelDeAbrigo`. 
No olvidemos que necesitamos agregar el atributo `temperaturaCorporal` en la clase Gato. Este atributo lo modelaremos como un `double` y lo inicializaremos en el constructor con el valor `37.0`, que es la temperatura normal de un gato.

Lo mismo que con las prendas ocurre con las comidas: `ceso`, `pescado` o `comidaBalanceada` afectan de la misma forma a los gatos, saciándolos en mayor o menor medida. Entonces, estos alimentos pueden ser instancias de una clase Comida, la cual debería tener como atributo `nivelDeSaciamiento`

#### Implementación
Comencemos por la Prenda:
```java
public class Prenda {
    private double nivelDeAbrigo;

    public Prenda(double nivelDeAbrigo){
        this.nivelDeAbrigo = nivelDeAbrigo;
    }

    public void abrigarA(Gato unGato){
        unGato.aumentarTemperaturaEn(this.nivelDeAbrigo);
    }

    public void quitateDe(Gato unGato){
        unGato.disminuirTemperaturaEn(this.nivelDeAbrigo);
    }
}
```
Si agregamos los métodos principales en la clase Gato, la misma quedaría:
```java
public class Gato {
    private Prenda prenda;
	private double temperaturaCorporal;
	
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
```
Para tener en cuenta:
- En Java, a diferencia de Kotlin, no existen las llamadas seguras a los atributos. Por este motivo, preguntamos si el atributo `prenda` era distinto de `null`. Si no hacíamos esto y alguien hubiera llamado al método `sacateElAbrigo()`, podría haber explotado en momento de ejecución. De todas formas, en este caso solamente realizamos esta verificación para hacer esta aclaración. De ahora en más, no preguntaremos si nuestros atributos son nulos o no. En otra etapa posterior veremos cómo solucionar estas cosas.

Ahora vamos con la comida
```java
public class Comida {
    private int nivelDeSaciedad;

    public Comida(int nivelDeSaciedad){
        this.nivelDeSaciedad = nivelDeSaciedad;
    }

    public void afectarHambreDe(Gato unGato, int raciones){
        unGato.disminuirHambreEn(raciones * this.nivelDeSaciedad);
    }
}
```
Y si agregamos el método principal en la clase Gato, quedaría:
```java
public class Gato {
    private int hambre;
	
	public void disminuirHambreEn(int algunasUnidades){
        this.hambre -= algunasUnidades;
    }
	
    public void come(int algunasRaciones, Comida comida){
        comida.afectarHambreDe(this, algunasRaciones);
    }
}

```
#### Tests
##### En Java
Probemos abrigar a Gary con un Buso
```java
public class GatoTest {
    private Gato gary;

    @Before
    public void init(){
        this.gary = new Gato("Gary", Color.NARANJA);
    }

    @Test
    public void abrigarConBusoLevantaTemperaturaTest(){
        Prenda unBuzo = new Prenda(0.5);
        this.gary.abrigateCon(unBuzo);

        Assert.assertEquals(37.5, gary.getTemperaturaCorporal(), 0.0);
    }
}
```
Y ahora probemos darle de comer ceso
```java
public class GatoTest {
    private Gato gary;

    @Before
    public void init(){
        this.gary = new Gato("Gary", Color.NARANJA);
    }

    @Test
    public void comerCesoDisminuyeHambreTest(){
        Comida ceso = new Comida(2);
        this.gary.come(1, ceso);

        Assert.assertEquals(8, this.gary.getHambre());
    }
}
```
### Novena iteración
#### Dominio
Los gatos pueden jugar con muchos juguetes y todos ellos aumentan el nivel de diversión de éstos en cierta medida. Pero también pueden jugar con personas. Cuando un gato juega con una persona no solamente aumenta su nivel de diversión en 15 puntos, sino que también disminuye su energía en 2 puntos.

#### Diseño en objetos
Hasta ahora sabíamos que Gary tenía una bola de lana y un ratón, pero lo cierto es que todos los juguetes afectan de la misma forma a los gatos. Podríamos pensar, entonces, en generar una clase Juguete que tenga como atributo un nivel de diversión.  ¿Qué responsabilidad tiene esta clase? ¡Jugar con el gato! Por eso vamos a necesitar definir el mensaje `jugarCon(Gato unGato)`

Pero... los gatos no solamente pueden jugar con juguetes sino que también con personas. ¿Los gatos se ven afectados de la misma forma cuando juegan con las personas? No. Las personas no solamente aumentan el nivel de diversión de los gatos, sino que también disminuyen su energía.
No podemos unificar los conceptos de Persona y Juguete porque tienen comportamiento distinto: ambos pueden jugar con los gatos, pero los afectan de manera diferente. Lo cierto es que, si pensamos en crear una clase Persona, la misma también deberá poder jugar con un gato. Podríamos respetar la misma firma `jugarCon(Gato unGato)`.

Pensemos un segundo en el método principal que tendrá  la clase Gato: `jugarCon(??? jugable)` ¿Qué tipo es? Una vez más, podemos crear una interface y hacer que tanto Persona como Juguete la implementen. Llamemos a esta interface `Jugable`. Esta interface deberá establecer la firma del método `jugarCon(Gato unGato);`

¿Qué concepto acabamos de aplicar? ¡Polimorfismo! Un gato puede tratar de forma indistinta a una persona o a un juguete cuando le pedimos que juegue con él. Diremos, entonces, que tanto Persona como Juguete son polimórficos para Gato en el método `jugarCon`

#### Implementación
Comencemos definiendo la interface
```java
public interface Jugable {
    public void jugarCon(Gato unGato);
}
```
Y ahora vamos por la clase Juguete

```java
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
```
Para tener en cuenta:
- Para explicitar que una clase implementa una interface, se debe usar la palabra `implements`. Por ejemplo: `public class MiPrimeraClase implements UnaInterface`

¿Y Persona?
```java
public class Persona implements Jugable {
    private String nombre;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void jugarCon(Gato unGato){
        unGato.aumentarDiversionEn(15);
        unGato.disminuirEnergiaEn(2);
    }
}
```
Ahora solo nos falta agregar los métodos al Gato:
```java
public class Gato {
    private String nombre;
    private int energia;
    private int diversion;

    public Gato(String nombre){
        this.nombre = nombre;
		this.energia = 10;
        this.diversion = 0;
    }

    public void disminuirEnergiaEn(int algunasUnidades){
        this.energia -= algunasUnidades;
    }

    public void aumentarDiversionEn(int algunasUnidades){
        this.diversion += algunasUnidades;
    }

    public void jugaCon(Jugable jugable){
        jugable.jugarCon(this);
    }
}
```
#### Tests
##### En Java
Vamos a hacer jugar a Gary con un ratón y con su dueño:
```java
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
    public void jugarConRatonTest(){
        Juguete unRaton = new Juguete(10);
        this.gary.jugaCon(unRaton);

        Assert.assertEquals(10, this.gary.getDiversion());
    }

    @Test
    public void jugarConPersona(){
        Persona eze = new Persona("Eze");
        this.gary.jugaCon(eze);

        Assert.assertEquals(15, this.gary.getDiversion());
        Assert.assertEquals(8, this.gary.getEnergia());
    }
}

```
### Décima iteración
#### Dominio
Por último, vamos a querer decirle a un gato que camine hacia un lugar. Sabemos que todos los gatos siempre visitan los mismos lugares que Gary, y ellos son:
1. La casa de algún vecino
2. La cocina
3. La habitación

En esta iteración nos va a interesar:
- Saber en qué punto se encuentra el gato cuando lo mandamos a caminar hacia algún lugar
- Saber cuántas veces fue visitada la casa de algún vecino
- Saber cuántos pelos tiene la cocina donde vive algún gato
- Saber el nivel de desorden de la habitación donde vive algún gato


#### Diseño en objetos
En primer lugar vamos a modificar la implementación que habíamos realizado [anteriormente](https://github.com/ezequieloscarescobar/gary2#cuarta-iteración "anteriormente"). Antes, nuestro punto (en Gary) estaba conformado por dos atributos: `puntoX` y `puntoY`. Ahora vamos a cosificar a nuestro punto y convertirlo en objeto. Para eso, vamos a crear una clase Punto cuya responsabilidad principal será la de calcular la distancia absoluta a otro punto. 

Veamos ahora qué sucede con los lugares. 
Ante la visita de un gato, cada lugar reacciona de forma diferente: los vecinos contarán las veces que fueron visitados, las cocinas contarán los pelos y las habitaciones se desordenarán. Pero... ¿qué tienen en común todos estos lugares? Todos ellos pueden ser visitados por un gato y, además, todos tienen un punto que los ubica geográficamente.
Podemos pensar, entonces, en generar una clase abstracta `Lugar` y tres clases hijas: `CasaDelVecino`, `Cocina` y `Habitacion`. El atributo `punto` lo podríamos ubicar en la clase Lugar para evitar repetirlo por las tres clases hijas. Además, vamos a necesitar definir el mensaje `serVisitadoPor(Gato unGato)` en la clase Lugar, cuyo método quedará vacío por no haber un comportamiento en común entre las tres clases hijas. Cada clase hija deberá heredar de Lugar y redefinir el método `serVisitadoPor(Gato unGato)`  para hacer lo que realmente tenga que hacer. Por ejemplo, la CasaDelVecino aumentará su contador de visitas (el contador de visitas deberá ser un atributo de esta clase).
#### Implementación
Comencemos por definir la clase Punto:
```java
public class Punto {
    private int posicionX;
    private int posicionY;

    public Punto(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int distanciaAbsolutaEntre(Punto otroPunto){
        int distanciaEnX = this.diferenciaAlCuadradoEntre(this.posicionX, otroPunto.getPosicionX());
        int distanciaEnY = this.diferenciaAlCuadradoEntre(this.posicionY, otroPunto.getPosicionY());
        return (int) Math.sqrt(distanciaEnX + distanciaEnY);
    }

    private int diferenciaAlCuadradoEntre(int unPunto, int otroPunto){
        return (unPunto - otroPunto)*(unPunto - otroPunto);
    }
}
```
Si agregamos el atributo en Gato, nos quedaría:
```java
public class Gato {
    private String nombre;
    private Color color;
    private Punto punto;

    public Gato(String nombre, Color color){
        this.nombre = nombre;
        this.color = color;
        this.punto = new Punto(0,0);
    }
}
```
Claro, nuestros gatos siempre deberían arrancar en el (0,0) y es por eso que instanciamos un punto en el constructor con esos valores.

Ahora vayamos por nuestra clase abstracta `Lugar`
```java
public abstract class Lugar {
    private Punto punto;

    protected Lugar(Punto punto){
        this.punto = punto;
    }

    public Punto getPunto() {
        return punto;
    }

    public void serVisitadoPor(Gato unGato){

    }
}
```
Nótese la palabra `abstract`: esta palabra debe ser utilizada para indicar que una clase es abstracta.

Por último, definamos nuestros tres lugares:
```java
public class CasaDelVecino extends Lugar {
    private int cantidadVisitas;

    public CasaDelVecino(Punto punto) {
        super(punto);
        this.cantidadVisitas = 0;
    }

    @Override
    public void serVisitadoPor(Gato unGato){
        this.cantidadVisitas++;
    }
}
```
```java
public class Cocina extends Lugar {
    private int cantidadDePelos;

    public Cocina(Punto punto) {
        super(punto);
        this.cantidadDePelos = 1;
    }

    public int getCantidadDePelos() {
        return cantidadDePelos;
    }

    @Override
    public void serVisitadoPor(Gato unGato){
        this.cantidadDePelos++;
    }
}
```
```java
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
```
Algo importante para recordar:
- Cuando queremos establecer una herencia, tenemos que utilizar la palabra `extends`, por ejemplo: `public class MiClase extends UnaClaseAbstracta`

#### Tests
##### En Java
En el primer test, vamos a hacer caminar a Gary hasta la casa del vecino y verificaremos si la ubicación actual de este gato se corresponde con la ubicación de la casa del vecino. ¿Estaremos comparando por igualdad o por identidad?
```java
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
    public void caminarHaciaLaCasaDelVecinoTest(){
        Lugar casaDePepe = new CasaDelVecino(new Punto(180,5));
        this.gary.caminaHacia(casaDePepe);

        Assert.assertEquals(8, this.gary.getEnergia());
        Assert.assertEquals(casaDePepe.getPunto(), this.gary.posicionActual());
    }

}

```
Si prestamos atención al test anterior, nos daríamos cuenta que acabamos de instanciar alguna casa de algún vecino pero el tipo de la referencia al objeto fue `Lugar` y no `CasaDelVecino`. En este sentido, vamos a poder tratar al objeto recién instanciado como un Lugar y no como CasaDelVecino. ¿Qué mensajes entiende Lugar? `serVisitadoPor(Gato unGato)` y `Punto getPunto()`. Quiere decir que a mi objeto `casaDePepe` voy a poder mandarle únicamente estos dos mensajes porque lo hemos restringido al tipo Lugar. En cambio, si hubiera hecho `CasaDelVecino casaDePepe = new CasaDelVecino(new Punto(180,5));`, además de poder mandarle los mensajes que entiende Lugar, podría mandarle el mensaje `getCantidadVisitas()`
Lo cierto es que si lo declaraba de esta última forma, podría haber mandado a cualquier gato a visitarlo sin problemas. ¿Por qué? Porque `CasaDelVecino` es un `Lugar`, porque hereda de dicha clase.

Retomando los tests, en segundo lugar haremos caminar a Gary hacia la cocina y verificaremos que la cantidad de pelo haya aumentado.
```java
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
    public void caminarHaciaCocinaAumentaPelosTest(){
        Cocina cocina = new Cocina(new Punto(4,30));
        this.gary.caminaHacia(cocina);

        Assert.assertEquals(2, cocina.getCantidadDePelos());
    }
}

```

Por último, haremos caminar a 3 gatos distintos hacia la misma habitación. Verificaremos que el desorden sea de 3 puntos (1 punto por cada gato que visitó el lugar).
```java
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

```
