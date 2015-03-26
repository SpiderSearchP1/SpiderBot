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
public class NodoKeyword <dp> extends Nodo{

    private String [] Urlpadre;
    private int [] countPpage;
    private int indice;
    private int MaxArray;
    private int growPor;
    
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
    
    public NodoKeyword(dp pData, String Urlpadre) {
        super(pData);
        indice=0;
        MaxArray=10;
        growPor=30;
        this.Urlpadre= new String[MaxArray];
        this.Urlpadre[indice]=Urlpadre;
        countPpage= new int[MaxArray];
    }
    public void setPadre(String Urlpadre){
        if (indice==MaxArray)
            resize();
        this.Urlpadre[indice]=Urlpadre;
        indice++;
    }
    
    public void upCount(){
        countPpage[indice]=(countPpage[indice])+1;
    }
    
    public void printPadre(){
        for(int i=0; i<MaxArray;i++){
            System.out.println(Urlpadre[i]+"..Cantidades de veces Encontrada la palabra: "+countPpage[i]);
        }
    }
    
    private void resize(){
        int NewMaxArray= MaxArray+(MaxArray*(growPor/100));
        String [] tmp= new String [NewMaxArray];
        int [] tmp2= new int[NewMaxArray];
        for(int i=0; i<MaxArray;i++){
            tmp[i]=Urlpadre[i];
            tmp2[i]=countPpage[i];
        }
        MaxArray= NewMaxArray;
        Urlpadre=tmp;
        countPpage=tmp2;
    }
}
