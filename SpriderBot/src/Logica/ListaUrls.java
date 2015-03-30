/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 * clase creada para la base de datos para los urls que se van ingresando 
 * para ser procesados por los threads hijos del SpiderBot
 * @author osboxes <-------------------- nombre de la VM de ubuntu
 * @param <dp> generico para la clase
 */
public class ListaUrls<dp> extends ListaSdoble{
    
    private NodoUrl _head;
    private NodoUrl _tail;

    @Override
    public NodoUrl getHead(){
        return _head;
    }
    
    @Override
    public NodoUrl getTail(){
        return _tail;
    }
    
    /**
     * metodo especial para encolar a la lista de Urls que recibe la 
     * urls que se quiere y se le ingresa el nivel de profundidad.
     * @param dato la url que se ingresa 
     * @param depth nivel de profundidad.
     */
    public void enQueue(dp dato,int depth){
        if(_head==null){
            _head=_tail= new NodoUrl(dato);
            _head.setDepth(depth);
        }
        else{
            NodoUrl tmp1=_tail;
            tmp1.setNext(new NodoUrl(dato));
            _tail=(NodoUrl)tmp1.getNext();
            _tail.setDepth(depth);
        }
    }
    
    /**
     * metodo para borrar los head una vez que una Url ya se haya seleccionado
     */
    public void deQueue(){
        _head=(NodoUrl)_head.getNext();
    }
    
    
    public void print(){
        NodoUrl tmp=_head;
        while (tmp!=null){
            System.out.println(tmp.getData()+" profundidad: "+ tmp.geDepth());
            tmp=(NodoUrl)tmp.getNext();
        }
    }
    
    /**
     * prueba unitaria para la lista de urls.
     * @param args 
     */
    public static void main(String[] args) {
        ListaUrls l= new ListaUrls();
        l.enQueue("www.padre.com", 0);
        l.enQueue("www.padre1.com", 0);
        l.enQueue("www.padre2.com", 0);
        l.enQueue("www.padre3.com", 0);
        l.enQueue("www.hijo.com", 1);
        l.enQueue("www.hijo1.com", 1);
        l.enQueue("www.hijo2.com", 1);
        l.enQueue("www.hijo3.com", 1);
        l.enQueue("www.hijo.com", 2);
        l.print();
    }
}
