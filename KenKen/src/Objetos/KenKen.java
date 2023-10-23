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
    int[][]solucion = new int[6][6];

    public KenKen() {
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

    public int[][] getSolucion() {
        return solucion;
    }

    public void setSolucion(int[][] solucion) {
        this.solucion = solucion;
    }


            
    public void insertarValorSolucion(String celda){
        String[] partes = celda.split("[,()]");
        int valor = Integer.parseInt(partes[0].trim());
        int fila = Integer.parseInt(partes[1].trim());
        int columna = Integer.parseInt(partes[2].trim());      
        solucion[fila][columna]=valor;
    }

    

    



    
    
            
}
