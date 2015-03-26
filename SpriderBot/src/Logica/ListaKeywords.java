/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Ellioth
 */
public class ListaKeywords <dp>{
    private NodoKeyword _head;
    private NodoKeyword _tail;
    /**
     * metodo para retornar el _head de una lista
     * @return _head
     */
    public NodoKeyword getHead(){
        return _head;
    }
    
    public void insertHead(dp dato, String UrlPadre){
        Nodo tmp1= _head;
        _head=new NodoKeyword(dato,UrlPadre);
        _head.setNext(tmp1);
    }
    
    public dp find(dp dato){
        Nodo tmp =_head;
        while(tmp!=null||tmp.getData().equals(dato)){
            tmp=tmp.getNext();
        }
        return (dp)tmp.getData();
    }
    
    public void delete(dp dato){
        Nodo tmp=_head;
        Nodo tmp2=tmp;
        while(tmp!=null|| !tmp.getData().equals(dato)){
            tmp2=tmp;
            tmp=tmp.getNext();
        }
        if(tmp==null)
            return;
        else if(tmp==tmp2 && tmp.getData().equals(dato))
            _head=(NodoKeyword)_head.getData();
        else{
            if(tmp2.getData().equals(dato))
                tmp2.setNext(tmp.getNext());
            else
                return;
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
    
    public void upCount(){
        _head.upCount();
    }
    
    public void setPadre(String UrlPadre){
        _head.setPadre(UrlPadre);
    }
    
    public static void main(String[] args) {
        ListaKeywords l= new ListaKeywords();
        l.insertHead("hola","www.wikipedia.org/java/oracle/sunMicroSystem");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.insertHead("mundo", "www.wikipedia.org/java/oracle/Micro_Sun_System");
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.insertHead("nueva", "www.wikipedia.org/java/oracle/sun_Micro_System");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.google.com/pq?=/?como_hacer_nueva_carpeta");
        l.upCount();
        l.upCount();
        l.upCount();
        l.insertHead("lista", "www.wikipedia.org/java/oracle/sun_Micro_System");
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
}
