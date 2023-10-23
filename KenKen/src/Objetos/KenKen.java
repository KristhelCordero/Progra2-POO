/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class KenKen {
    String nombre;
    int dificultad;
    //String rutaImagen; //ruta a la imagen del Ken Ken
    List<List<Integer>> solucion= new ArrayList<>();

    public KenKen() {
    }
    
    public KenKen(String nombre, int dificultad,List<List<Integer>> solucion){
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.solucion = solucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public List<List<Integer>> getSolucion() {
        return solucion;
    }

    public void setSolucion(List<List<Integer>> solucion) {
        this.solucion = solucion;
    }
    
    

    



    
    
            
}
