
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

    public Configuracion(boolean posicion, boolean sonido, int dificultad, int reloj) {
        this.posicionBarra = posicion;
        this.sonido = sonido;
        this.dificultad = dificultad;
        this.reloj = reloj;
    }

    Configuracion() {
        this.posicionBarra = true;
        this.sonido = true;
        this.dificultad = 1;
        this.reloj = 3;
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
