/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Accion {
    int fila;
    int columna;
    boolean agregar;//si se agrego un numero es true, si se quitó es false
    String dato;

    public Accion(int fila, int columna, String dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
    }
    
    
    /*
    public Accion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.agregar = true;
    }
    */

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isAgregar() {
        return agregar;
    }

    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.fila;
        hash = 79 * hash + this.columna;
        hash = 79 * hash + (this.agregar ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.dato);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accion other = (Accion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        if (this.agregar != other.agregar) {
            return false;
        }
        return Objects.equals(this.dato, other.dato);
    }
    
    
    
    
}
