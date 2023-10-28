/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    
    public static void escribirArchivosBinariosConfiguracion(Configuracion configuracion){
        File archivo = new File("configuracion.dat");
        try{
            FileOutputStream fos = new FileOutputStream(archivo) ;
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(configuracion);
            oos.close();
            fos.close();
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    public static Configuracion leerArchivoBinarioConfiguracion(){
        File archivo = new File("configuracion.dat");
        try{
            FileInputStream fis = new FileInputStream(archivo);
            System.out.println("Lo encuentra");
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            System.out.println("no se ha caido");
            Configuracion configuracion = (Configuracion) ois.readObject();
            System.out.println("magia");
            return configuracion;
        }catch (Exception e){ 
            System.out.println("Error");
            e.printStackTrace();
            return null;
        }
        
    }
}
