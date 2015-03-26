/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriderbot;

import Logica.ListaSpiderBot;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXml <dp> {
    
    private File path;
    private DocumentBuilder Dbuilder;
    private DocumentBuilderFactory Dfactory;
    private Document docu;
    private ListaSpiderBot Urls;
    private ListaSpiderBot SpAtri;
    
    /**
     * contructor de la clase
     * nos inicializa las listas
     * que se van a estar urilizando
     */
    public ReadXml(){
        Urls= new ListaSpiderBot();
        SpAtri= new ListaSpiderBot();
    }
    /**
     * lector de archivos xml, recibe 
     * como parametro un integer que nos indica 
     * a que cosas va a leer del xml
     * @param diferencial 
     */
    public void readAll(int diferencial){
        try{
            path=new File("C:\\Users\\Ellioth\\Documents\\NetBeansProjects\\New Folder\\SpriderBot\\src\\Xmls\\WebPages.xml");
            Dfactory = DocumentBuilderFactory.newInstance();
            Dbuilder= Dfactory.newDocumentBuilder();
            docu= Dbuilder.parse(path);
            docu.getDocumentElement().normalize();
            if(diferencial==1){
                NodeList lista = docu.getElementsByTagName("targets");
                Node nodoL = lista.item(0);
                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                    Element elm= (Element)nodoL;
                    Urls.enQueue(elm.getElementsByTagName("url").item(0).getTextContent(),0);
                    Urls.enQueue(elm.getElementsByTagName("url").item(1).getTextContent(),0);
                }
            }
            else{
                NodeList lista = docu.getElementsByTagName("spider");
                Node nodoL = lista.item(0);
                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                    Element elm= (Element)nodoL;
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("maxthreads").item(0).getTextContent()),0);
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("recursivity").item(0).getTextContent()),0);
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("reindex").item(0).getTextContent()),0);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * metodo que retorna una lista de
     * atributos en 
     * @return 
     */
    public ListaSpiderBot getSpAtri(){
        return this.SpAtri;
    }
    
    public ListaSpiderBot getUrls(){
        return this.Urls;
    }
}
