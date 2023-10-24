
package Objetos;

/**
 *
 * @author Usuario
 */
public class PilaAcciones{
    private NodoAccion top;
    
    PilaAcciones(){
        top=null;
    }
    
    public void push(Accion t){
        NodoAccion nodo=new NodoAccion();
        nodo.dato=t;
        if(empty()){
            top=nodo;
        }else{
            nodo.sucesor= top;
            top=nodo;
        }
    }
    
    public void imprimirLista(){
        NodoAccion nodo;
        nodo=top;
        while (nodo!= null){
            System.out.println(nodo.dato);
            nodo=nodo.sucesor;
        }
    }
    
    public NodoAccion peek(){
        return top;
    }

    public void clear(){
        top=null;
    }
    
    public boolean empty(){
        return top == null; 
    }
    
    public Accion pop(){
        if (top==null){
            return null;
        }else{
            NodoAccion tmp=top;
            top=top.sucesor;
            tmp.sucesor=null;
            return tmp.dato;
        }
    }
    

}