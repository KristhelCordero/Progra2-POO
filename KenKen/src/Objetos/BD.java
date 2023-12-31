
package Objetos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
    Configuracion configuracion= new Configuracion();
    List<KenKen> listaKenKen = new ArrayList<>();
    PilaAcciones acciones=new PilaAcciones();
    PilaAcciones accionesDeshechas=new PilaAcciones();
     
    public void BD(){
       //extraerXMLListaKenKen();
       //generarConfiguracionDefault();
    }
    
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
    
    //KENKEN
    public KenKen convertirNodoEnKenKen(Element eHijo){
        KenKen kenken= new KenKen();
        NodeList nietos= eHijo.getChildNodes();
        for(int k=0; k<nietos.getLength();k++){
            //System.out.println("Largo: "+nietos.getLength());
            //System.out.println("index: "+k);
            Node nieto = nietos.item(k);
            if(nieto.getNodeType()==Node.ELEMENT_NODE){
                //System.out.println("Se evalua el nodo"+nieto.getNodeName());
                if("codigo".equals(nieto.getNodeName())){
                    kenken.setNombre(nieto.getTextContent());
                }
                if("nivelDificultad".equals(nieto.getNodeName())){
                    kenken.setDificultad(
                            Funciones.pasarStringDificultadAInt(
                                    nieto.getTextContent()));
                }
                if("celda".equals(nieto.getNodeName())){
                    //System.out.println(nieto.getTextContent());
                    kenken.insertarValorSolucion(nieto.getTextContent());
                    //System.out.println("sinserto");
                }

            }
        }
        return kenken;
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
                //System.out.println(nodoPadre.getNodeName());//Ken Ken
                if(nodoPadre.getNodeType()==Node.ELEMENT_NODE){
                    Element ePadre = (Element) nodoPadre;
                    NodeList hijos = ePadre.getChildNodes();
                    for (int j=0; j<hijos.getLength(); j++){
                        Node hijo = hijos.item(j);
                        //System.out.println(hijo.getNodeName());//partida solucion partida
                        if(hijo.getNodeType()==Node.ELEMENT_NODE){
                            if ("solucion".equals(hijo.getNodeName())){
                                Element eHijo = (Element) hijo;
                                //System.out.println("se convierte nodo en kenken");
                                listaKenKen.add(convertirNodoEnKenKen(eHijo));
                                //System.out.println("pasa la funcion");
                            }
                        }
                    }
                } 
            }
        }catch(ParserConfigurationException | SAXException | IOException ex){
            System.out.println("No se pudo leer el XML");
        }
    }
    
    public void imprimirListaKenKen(){
        //System.out.println("llega");
        for(KenKen kenken: listaKenKen){
            kenken.imprimir();
        }
    }
    
    public String extraerKenKenActual(){
        Random rand = new Random();
        String nombre = "src/imagenes/";
        
        int numeroKenKen = rand.nextInt(3) + 1;
        switch (configuracion.getDificultad()) {
            case 1 -> nombre+="E-"+Integer.toString(numeroKenKen)+"_in.png";
            case 2 -> nombre+="H-"+Integer.toString(numeroKenKen)+"_in.png";
            default -> nombre+="D-"+Integer.toString(numeroKenKen)+"_in.png";
        }
        return nombre;
    }
    //Configuracion
    
    public void generarConfiguracionDefault(){
        configuracion.resetear();
    }
    
    public KenKen buscarKenKen(String nombre){
        nombre=nombre.substring(13, nombre.length() - 6);
        nombre+="com";
        for(KenKen kenken:listaKenKen){
            //System.out.println(kenken.nombre);
            if(kenken.nombre.equals(nombre)){
               return kenken;
            }
        }
        return null;
    }
    
    //ACCIONES
    
    public void annadirAccionEscribir(int fila, int columna, String dato){
        Accion accion=new Accion(fila,columna,dato);
        accion.agregar=true;
        acciones.push(accion);
    }
    public void annadirAccionBorrar(int fila, int columna, String dato){
        Accion accion=new Accion(fila,columna,dato);
        accion.agregar=false;
        acciones.push(accion);
    }
    
    public Accion deshacerAccion(Accion accionDesecha){
        if(!acciones.empty()){
            Accion accion = acciones.pop();
            accionesDeshechas.push(accionDesecha);
            return accion;
        }
        return null;
    }
    public Accion rehacerAccion(Accion accionHecha){
        if(!accionesDeshechas.empty()){
            Accion accion = accionesDeshechas.pop();
            acciones.push(accionHecha);
            return accion;
        }
        return null;
    }
    
    public Accion mostrarUltimaAccionHecha(){
        if (!acciones.empty()){
            return acciones.peek();
        }
        return null;
    }
    public Accion mostrarUltimaAccionDeshecha(){
        if (!accionesDeshechas.empty()){
            return accionesDeshechas.peek();
        }
        return null;
    }
    
    public void limpiarPilas(){
        acciones.clear();
        accionesDeshechas.clear();
    }
    
    
}
