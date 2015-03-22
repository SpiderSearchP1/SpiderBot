/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriderbot;

import DataBase.Lista;
import DataBase.Nodo;
import java.net.Socket;

public class SpiderBot {

    private int maxthreads;
    private int recursivity;
    private int reindex;
    private ReadXml lectorXml;
    private Lista listUrls;
    private String URl;
    private Socket socket;
    public SpiderBot(){
        lectorXml= new ReadXml();
        lectorXml.readAll(1);
        lectorXml.readAll(0);
        extrac(lectorXml.getSpAtri());
        listUrls=lectorXml.getUrls();
    }
    
    private void extrac(Lista list){
        try{
            Nodo tmp= list.getHead();
            reindex= (int)tmp.getData();
            recursivity= (int)tmp.getNext().getData();
            maxthreads=(int)tmp.getNext().getNext().getData();
            
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
    public void setConnect(){
        socket= new Socket();
        
    }
    public void print(){
        System.out.println("maxthreads: "+ maxthreads);
        System.out.println("recursivity: "+ recursivity);
        System.out.println("reindex: "+ reindex);
        listUrls.print();
    }
    
    public static void main(String[] args) {
        SpiderBot sp= new SpiderBot();
        sp.print();
    }
}
