/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

public class Lista<dp> {
    
    private Nodo _head;
    
    public Nodo getHead(){
        return _head;
    }
    
    public void insertHead(dp dato){
        Nodo tmp1= _head;
        _head=new Nodo(dato);
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
            _head=_head.getNext();
        else{
            if(tmp2.getData().equals(dato))
                tmp2.setNext(tmp.getNext());
            else
                return;
        }
    }
    
    public void print(){
        Nodo tmp=_head;
        while (tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNext();
        }
    }
}
