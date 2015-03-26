/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

public class ListaSpiderBot<dp>{
    
    private NodoUrl _head;
    private NodoUrl _tail;

    public NodoUrl getHead(){
        return _head;
    }
    
    public NodoUrl getTail(){
        return _tail;
    }
    
    public void enQueue(dp dato,int depth){
        if(_head==null){
            _head=_tail= new NodoUrl(dato);
            _head.setDepth(depth);
        }
        else{
            NodoUrl tmp1=_tail;
            tmp1.setNext(tmp1);
            _tail=(NodoUrl)tmp1.getNext();
            _tail.setDepth(depth);
        }
    }
    public dp find(dp dato){
        NodoUrl tmp =_head;
        while(tmp!=null||tmp.getData().equals(dato)){
            tmp=(NodoUrl)tmp.getNext();
        }
        return (dp)tmp.getData();
    }
    
    public void deQueue(dp dato){
        _head=(NodoUrl)_head.getNext();
    }
    
    public void print(){
        NodoUrl tmp=_head;
        while (tmp!=null){
            System.out.println(tmp.getData());
            tmp=(NodoUrl)tmp.getNext();
        }
    }
}
