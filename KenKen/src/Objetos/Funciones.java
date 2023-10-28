/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    
    
    public static String crearPDFAyuda(String link){
        try{
            Document document = new Document();//

                    
             
            String destino = "ayuda.pdf";//
            PdfWriter.getInstance(document, new FileOutputStream(destino));//
            document.open();//
            //codigo
            Paragraph titulo = new Paragraph("Link a manual de usuario\n ", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph parrafoLink = new Paragraph(link);

            document.add(titulo);
            document.add(parrafoLink);


            document.close();// fin plantilla
            return "PDF creado";

        } catch(FileNotFoundException | DocumentException ex){
            return "Error al crear el PDF";
        }
    }
}
