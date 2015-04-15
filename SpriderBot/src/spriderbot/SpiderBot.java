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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

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
    private Nodo search;
    private String URl;
    
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
        readPages();
        /**
        for(int i=0; i<maxthreads;i++){
            
        }*/
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
     * metodo para ir realizando la lectura de paginas webs y la extraccion de 
     * urls que esta misma contiene.
     */
    public void readPages(){
        search= listUrls.getHead();
        try{
            URL url = new URL((String)search.getData());
            URLConnection urlCon = url.openConnection();
            BufferedReader in;
            if (urlCon.getHeaderField("Content-Encoding")!= null && urlCon.getHeaderField("Content-Encoding").equals("gzip"))
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            else
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while (in.readLine() != null){
                inputLine=in.readLine();
                System.out.println(inputLine);
                //sb.append(inputLine);
            }
            in.close();
            //System.out.println(sb.toString());

        //return sb.toString();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * metodo de prueba para imprimir el contenido de la lista de urls y los atributos
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
    }
}
