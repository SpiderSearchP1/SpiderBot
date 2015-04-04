/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 * calse de tipo lista doble para ir haciendo la base de datos 
 * para las palabras de busqueda.
 * @param <dp> generico para la clase
 * @author Ellioth
 */
public class ListaKeywords <dp> extends ListaSdoble{
    
    private NodoKeyword _head;
    private NodoKeyword _tail;
    
    @Override
    public Nodo getTail() {
        return _tail;
    }
    
    @Override
    public Nodo getHead() {
        return super.getHead(); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * metodo para enconlar especial que establece el padre o los
     * padres de cada uno de los Nodos.
     * @param dato
     * @param Urlpadre 
     */
    public void enQueue(dp dato,String Urlpadre){
        if(_head==null){
            _head=_tail= new NodoKeyword(dato,Urlpadre);
        }
        else{
            NodoKeyword tmp1=_tail;
            tmp1.setNext( new NodoKeyword(dato, Urlpadre));
            _tail=(NodoKeyword)tmp1.getNext();
            _tail.setPrev(tmp1);
        }
    }
     
    public void print(){
        NodoKeyword tmp=_head;
        while (tmp!=null){
            System.out.println(tmp.getData());
            tmp.printPadre();
            System.out.println("<-------------------------------------------------------------------------->");
            tmp=(NodoKeyword)tmp.getNext();
        }
        
    }
    
    /**
     * metodo par aumentar la cuenta para cada uno de los nodos
     * de la cantidad de veces que le encontro en una pagina web 
     * a la palabra
     */
    public void upCount(){
        _tail.upCount();
    }
    
    /**
     * metodo para ingresar un nuevo padre aparte del padre proviente 
     * de la primera pagina o de paginas anteriores.
     * @param UrlPadre 
     */
    public void setPadre(String UrlPadre){
        _tail.setPadre(UrlPadre);
    }
    
    public int lengthLista(){
        int i=0;
        NodoKeyword tmp= _head;
        while(tmp!=null){
            tmp=(NodoKeyword)tmp.getNext();
            i++;
        }
        return i;
    }
    
    /**
     * pruebas para la lista
    public static void main(String[] args) {
        ListaKeywords l= new ListaKeywords();
        l.enQueue("hola","www.wikipedia.org/java/oracle/sunMicroSystem");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.enQueue("mundo", "www.wikipedia.org/java/oracle/Micro_Sun_System");
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.enQueue("nueva", "www.wikipedia.org/java/oracle/sun_Micro_System");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.google.com/pq?=/?como_hacer_nueva_carpeta");
        l.upCount();
        l.upCount();
        l.upCount();
        l.enQueue("lista", "www.wikipedia.org/java/oracle/sun_Micro_System");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.oracleSun.org/docs/documentation/Java_8/Listas");
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.print();
    }
    */
}
