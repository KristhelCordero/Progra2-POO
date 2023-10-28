
package Objetos;

import java.io.Serializable;

/**
 *
 * @author KendallP
 */
public class Configuracion implements Serializable{
    
    boolean posicionBarra;//true: derecha; false: izquierda.
    boolean sonido;
    int dificultad; //1:facil; 2: medio; 3:dificil.
    int reloj; //1: cronometro; 2: timer; 3: no.
    Timer timer=new Timer();

    public Configuracion(boolean posicion, boolean sonido, int dificultad, int reloj) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
        this.timer.resetearTimer();
    }
    public Configuracion(boolean posicion, boolean sonido, int dificultad, int reloj, Timer timer) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
        this.timer= timer;
    }

    public Configuracion() {
        resetear();
    }

    public boolean isPosicion() {
        return posicionBarra;
    }

    public void setPosicion(boolean posicion) {
        this.posicionBarra = posicion;
    }

    public boolean isSonido() {
        return sonido;
    }

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getReloj() {
        return reloj;
    }

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
            System.out.println("Me cago en todo");
        }
        this.copiarConfiguracion(confDef);
    }
    
    
}
