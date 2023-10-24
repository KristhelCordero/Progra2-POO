
package Objetos;

/**
 *
 * @author Usuario
 */
public class Nodo<T> {
    public T dato;
    public Nodo<T> predecesor;
    public Nodo<T> sucesor;
    
    Nodo(){
        predecesor=null;
        sucesor=null;
    }
}
