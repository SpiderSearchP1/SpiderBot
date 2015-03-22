/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author Ellioth
 * @param <dp> generic para administracion de nodos
 */
public class Nodo<dp> {
    
    private dp dato;
    private Nodo NextNodo;
    private Nodo prevNodo;

    public Nodo(dp pData){
        this.dato= pData;
    }

    public dp getData(){
        return  dato;
    }
    
    public void setData(dp dato){
        this.dato=dato;
    }

    public Nodo getNext(){
        return NextNodo;
    }

    public Nodo getPrev(){
        return prevNodo;
    }
    public void setNext(Nodo pNodo){
        this.NextNodo=pNodo;
    }
    
    public void setPrev(Nodo pNodo){
        this.prevNodo=pNodo;
    }
        
}
