
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
    
    public NodoAccion peekLeft(){
        return cabezaLista;
    }
    
    public void clear(){
        cabezaLista=null;
        colaLista=null;
    }
    
    public boolean empty(){
        return cabezaLista == null;
    }
    
    public NodoAccion pop(){
        if (colaLista==null){
            return null;
        }else{
            NodoAccion tmp=colaLista;
            colaLista=colaLista.predecesor;
            colaLista.sucesor=null;
            return tmp;
        }
    }
    
    public NodoAccion popLeft(){
        if (cabezaLista==null){
            return null;
        }else{
            NodoAccion tmp=cabezaLista;
            cabezaLista=cabezaLista.sucesor;
            cabezaLista.predecesor=null;
            return tmp;
        }
    }
}