
package Objetos;

/**
 *
 * @author Usuario
 */
public class Pila<T> {
    private Nodo cabezaLista;
    private Nodo colaLista;
    
    Pila(){
        cabezaLista=null;
        colaLista=null;
    }
    
    public void push(T t){
        Nodo nodo=new Nodo<T>();
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
        Nodo nodo;
        nodo=cabezaLista;
        while (nodo!= null){
            System.out.println(nodo.dato);
            nodo=nodo.sucesor;
        }
    }
    
    public Nodo peek(){
        return colaLista;
    }
    
    public Nodo peekLeft(){
        return cabezaLista;
    }
    
    public void clear(){
        cabezaLista=null;
        colaLista=null;
    }
    
    public boolean empty(){
        return cabezaLista == null;
    }
    
    public Nodo pop(){
        if (colaLista==null){
            return null;
        }else{
            Nodo tmp=colaLista;
            colaLista=colaLista.predecesor;
            colaLista.sucesor=null;
            return tmp;
        }
    }
    
    public Nodo popLeft(){
        if (cabezaLista==null){
            return null;
        }else{
            Nodo tmp=cabezaLista;
            cabezaLista=cabezaLista.sucesor;
            cabezaLista.predecesor=null;
            return tmp;
        }
    }
}