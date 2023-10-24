
package Objetos;

/**
 *
 * @author Usuario
 */
public class PilaAcciones{
    private NodoAccion cabezaLista;
    private NodoAccion colaLista;
    
    PilaAcciones(){
        cabezaLista=null;
        colaLista=null;
    }
    
    public void push(Accion t){
        NodoAccion nodo=new NodoAccion();
        nodo.dato=t;
        if(cabezaLista==null){
            cabezaLista=nodo;
            colaLista=nodo;
        }else{
            nodo.predecesor= colaLista;
            colaLista.sucesor=nodo;
            colaLista=nodo;
        }
    }
    
    public void imprimirLista(){
        NodoAccion nodo;
        nodo=cabezaLista;
        while (nodo!= null){
            System.out.println(nodo.dato);
            nodo=nodo.sucesor;
        }
    }
    
    public NodoAccion peek(){
        return colaLista;
    }
    

    
    public void clear(){
        cabezaLista=null;
        colaLista=null;
    }
    
    public boolean empty(){
        return colaLista == null; 
    }
    
    public NodoAccion pop(){
        if (colaLista==null){
            return null;
        }else{
            NodoAccion tmp=colaLista;
            colaLista=colaLista.predecesor;
            if (colaLista!=null){
                colaLista.sucesor=null;
            }
            return tmp;
        }
    }
    

}