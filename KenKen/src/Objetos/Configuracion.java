
package Objetos;

/**
 *
 * @author KendallP
 */
public class Configuracion {
    
    boolean posicionBarra;//true: derecha; false: izquierda.
    boolean sonido;
    int dificultad; //1:facil; 2: medio; 3:dificil.
    int reloj; //1: cronometro; 2: timer; 3: no.
    Timer timer=new timer();

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
        this.posicionBarra = true;
        this.sonido = true;
        this.dificultad = 1;
        this.reloj = 3;
        this.timer.resetearTimer();
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
    public void resetear() {
        setConfiguracion(true,true,1,3);
    }
    
    
}
