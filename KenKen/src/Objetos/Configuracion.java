
package Objetos;

import java.io.Serializable;

/**
 * Objeto que registra las preferencias de configuracion del usuario del 
 * programa
 * @author KendallP
 */
public class Configuracion implements Serializable{
    
    boolean posicionBarra;//true: derecha; false: izquierda.
    boolean sonido;
    int dificultad; //1:facil; 2: medio; 3:dificil.
    int reloj; //1: cronometro; 2: timer; 3: no.
    Timer timer=new Timer();

    /**
     * Constructor de configuracion
     * @param posicion
     * @param sonido
     * @param dificultad
     * @param reloj
     */
    public Configuracion(boolean posicion, boolean sonido, int dificultad, int reloj) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
        this.timer.resetearTimer();
    }

    /**
     * Constructor de configuracion con timer iniciado
     * @param posicion
     * @param sonido
     * @param dificultad
     * @param reloj
     * @param timer
     */
    public Configuracion(boolean posicion, boolean sonido, int dificultad, int reloj, Timer timer) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
        this.timer= timer;
    }

    /**
     * constructor de configuracion predeterminada en el archivo .dat
     */
    public Configuracion() {
        resetear();
    }

    /**
     *verifica si la posicion de la ventana es a la derecha o izquierda
     * true=derecha
     * false=izquierda
     * @return
     */
    public boolean isPosicion() {
        return posicionBarra;
    }

    /**
     * modifica la posicion de la ventana
     * @param posicion
     */
    public void setPosicion(boolean posicion) {
        this.posicionBarra = posicion;
    }

    /**
     * confirmacion de si se permite el sonido final del juego o no
     * @return sonido
     */
    public boolean isSonido() {
        return sonido;
    }

    /**
     * cambia la permision del sonido 
     * @param sonido
     */
    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }

    /**
     * retorna la dificultad
     * 1 : facil
     * 2 : medio
     * 3 : dificil
     * @return dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * Modifica la dificultad 
     * @param dificultad
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * retorna el tipo de reloj en codigo de int
     * 1:cronometro
     * 2:timer
     * 3:no
     * @return
     */
    public int getReloj() {
        return reloj;
    }

    /**
     * Modifica el tipo de reloj que se va a manejar
     * @param reloj
     */
    public void setReloj(int reloj) {
        this.reloj = reloj;
    }

    public boolean isPosicionBarra() {
        return posicionBarra;
    }

    public void setPosicionBarra(boolean posicionBarra) {
        this.posicionBarra = posicionBarra;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    
    public void setConfiguracion(boolean posicion, boolean sonido, int dificultad, int reloj) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
    }
    public void copiarConfiguracion(Configuracion configuracion) {
        setConfiguracion(configuracion.posicionBarra,
                configuracion.sonido,
                configuracion.dificultad,
                configuracion.dificultad);
    }
    public void resetear() {
        Configuracion confDef = Funciones.leerArchivoBinarioConfiguracion();
        if (confDef == null){
            System.out.println("La cofiguracion no se generó de manera correcta");
        }
        this.copiarConfiguracion(confDef);
    }
    
    
}
