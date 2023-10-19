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
public class BD { 
    Configuracion configuracion;
    List<KenKen> listaKenKen = new ArrayList<>();
    
    public List<KenKen> sacarListaDificultad(){ //sujeto a cambios (se puede guardar en un parametro)
        List<KenKen> listaDificultad= new ArrayList<>();
        for(KenKen kenken:listaKenKen){
            if(configuracion.dificultad==kenken.dificultad){
                listaDificultad.add(kenken);
            }
        }
        return listaDificultad;
    }

    
}
