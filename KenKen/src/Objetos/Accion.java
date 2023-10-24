/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Usuario
 */
public class Accion {
    int fila;
    int columna;
    boolean agregar;//si se agrego un numero es true, si se quitó es false
    int dato;

    public Accion(int fila, int columna, int dato) {
        this.fila = fila;
        this.columna = columna;
        this.agregar = false;
        this.dato = dato;
    }
    
    public Accion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.agregar = true;
    }
    
    
    
    
}
