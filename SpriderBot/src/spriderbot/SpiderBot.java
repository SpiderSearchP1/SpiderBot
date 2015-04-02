/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriderbot;

import Xmls.ReadUrls;
import Logica.ListaSdoble;
import Logica.ListaUrls;
import Logica.Nodo;
import java.io.IOException;
import java.net.Socket;

/**
 * clase para el spiderbot, esta hace que el se lea el xml que contiene 
 * los urls targets y se empize a leer las paginas.
 * @author osboxes <----------------nombre de la amaquina virtual en ubuntu
 */
public class SpiderBot {

    private int maxthreads;
    private int recursivity;
    private int reindex;
    private ReadUrls lectorXml;
    private ListaUrls listUrls;
    private String URl;
    private Socket socket;
    
    /**
     * constructor de el spider bot, crea una instancia del lector de xml 
     * y hace que se lea la informacion de este xml para empezar a hacer 
     * busquedas
     */
    public SpiderBot(){
        lectorXml= new ReadUrls();
        lectorXml.readAll(1);
        lectorXml.readAll(0);
        extrac(lectorXml.getSpAtri());
        listUrls=lectorXml.getUrls();
        //setConnect();
    }
    
    /**
     * metodo que recibe una lista doble enlazada simple y saca los atributos 
     * para el spiderbot
     * @param list 
     */
    private void extrac(ListaSdoble list){
        Nodo tmp= list.getHead();
        reindex= (int)tmp.getData();
        recursivity= (int)tmp.getNext().getData();
        maxthreads=(int)tmp.getNext().getNext().getData();
    }
    
    /**
     * metodo para crear la coneccion y empezar analizar las urls targets 
     * proveniente del xml y de esta misma forma va ingresando los 
     * otros urls que se encuentran al analizar las urls targets
     */
    public void setConnect(){
        try{
            URl= (String) listUrls.getHead().getData();
            socket= new  Socket(URl, 80);
            System.out.println(socket.getInetAddress());
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }    
    }
    
    /**
     * metodo para imprimir el contenido de la lista de urls y los atributos
     * del spiderbot
     */
    public void print(){
        System.out.println("maxthreads: "+ maxthreads);
        System.out.println("recursivity: "+ recursivity);
        System.out.println("reindex: "+ reindex);
        listUrls.print();
    }
    
    /**
     * pruebas unitarias con el spiderbot
     * @param args 
     */
    public static void main(String[] args) {
        SpiderBot sp= new SpiderBot();
        sp.print();
    }
}
