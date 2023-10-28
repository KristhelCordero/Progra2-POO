/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Timer implements Serializable{
    int hora;
    int minuto;
    int segundo;
    int milisegundo;

    public Timer(int hora, int minuto, int segundo, int milisegundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.milisegundo = milisegundo;
    }
    public Timer() {

    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getMilisegundo() {
        return milisegundo;
    }

    public void setMilisegundo(int milisegundo) {
        this.milisegundo = milisegundo;
    }
    
    public void resetearTimer(){
        setHora(0);
        setMinuto(0);
        setSegundo(0);
        setMilisegundo(0);
    }
    
}
