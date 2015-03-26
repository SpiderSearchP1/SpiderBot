/*
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
public class NodoUrl <dp> extends Nodo {

    private int profundida;
    
    public NodoUrl(dp pData) {
        super(pData);
    }
    
    @Override
    public Object getData() {
        return super.getData(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrev(Nodo pNodo) {
        super.setPrev(pNodo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNext(Nodo pNodo) {
        super.setNext(pNodo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getPrev() {
        return super.getPrev(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getNext() {
        return super.getNext(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setDepth(int depth){
        profundida=depth;
    }
}
