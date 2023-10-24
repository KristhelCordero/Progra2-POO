
package Objetos;

/**
 *
 * @author Usuario
 */
public class NodoAccion {
    public Accion dato;
    public NodoAccion predecesor;
    public NodoAccion sucesor;
    
    NodoAccion(){
        predecesor=null;
        sucesor=null;
    }
}
