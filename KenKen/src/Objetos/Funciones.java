/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author KendallP
 */
public class Funciones {
    public static int pasarStringDificultadAInt(String sDificultad){
        if (sDificultad.equals("Dificil")){
            return 3;
        }
        if (sDificultad.equals("Medio")){
            return 2;
        }
        if (sDificultad.equals("Facil")){
            return 1;
        }else{return -1;}
    }
}
