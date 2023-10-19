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
    String rutaImagen; //ruta a la imagen del Ken Ken
    List<List<Integer>> solucion= new ArrayList<>();

    public KenKen(String nombre, int dificultad, String rutaImagen) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.rutaImagen = rutaImagen;
    }


    
    
            
}
