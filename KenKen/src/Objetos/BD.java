/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



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

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public List<KenKen> getListaKenKen() {
        return listaKenKen;
    }

    public void setListaKenKen(List<KenKen> listaKenKen) {
        this.listaKenKen = listaKenKen;
    }
    
    
    
    public void extraerXMLListaKenKen(){
        //String dirXMl=KenKen\kenken.xml;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("kenken.xml"));
            
            NodeList listaPartidas = documento.getElementsByTagName("KenKen");
            for (int i=0; i < listaPartidas.getLength() ; i++){
                Node nodoPadre = listaPartidas.item(i);
                System.out.println(nodoPadre.getNodeName());//Ken Ken
                if(nodoPadre.getNodeType()==Node.ELEMENT_NODE){
                    
                    Element ePadre = (Element) nodoPadre;
                    NodeList hijos = ePadre.getChildNodes();
                    for (int j=0; j<hijos.getLength(); j++){
                        Node hijo = hijos.item(j);
                        //System.out.println(hijo.getNodeName());//partida solucion partida
                        if(hijo.getNodeType()==Node.ELEMENT_NODE){
                            if (hijo.getNodeName()=="solucion"){
                                
                                Element eHijo = (Element) hijo;
                                NodeList nietos= eHijo.getChildNodes();
                                for(int k=0; k<nietos.getLength();k++){
                                    Node nieto = nietos.item(k);                  
                                    if(nieto.getNodeType()==Node.ELEMENT_NODE){
                                        System.out.println(nieto.getNodeName());
                                    }
                                }

                            }
                            //System.out.println(hijo.getNodeName()+" "+hijo.getTextContent());
                        }
                    }
                }
                
            }
            }catch(ParserConfigurationException | SAXException | IOException ex){
                System.out.println("No se pudo leer el XML");
            }
        
    }

        
}
