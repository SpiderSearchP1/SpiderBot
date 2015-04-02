/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xmls;

import Logica.ListaSdoble;
import Logica.ListaUrls;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXml {
    
    private File path;
    private DocumentBuilder Dbuilder;
    private DocumentBuilderFactory Dfactory;
    private Document docu;
    private ListaUrls Urls;
    private ListaSdoble SpAtri;
    
    /**
     * contructor de la clase
     * nos inicializa las listas
     * que se van a estar urilizando
     */
    public ReadXml(){
        Urls= new ListaUrls();
        SpAtri= new ListaSdoble();
    }
    /**
     * lector de archivos xml, recibe 
     * como parametro un integer que nos indica 
     * a que cosas va a leer del xml
     * @param diferencial 
     */
    public void readAll(int diferencial){
        try{
            //path=new File("\\Xmls\\WebPages.xml");
            Dfactory = DocumentBuilderFactory.newInstance();
            Dbuilder= Dfactory.newDocumentBuilder();
            docu= Dbuilder.parse("web_pages.xml");
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
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("maxthreads").item(0).getTextContent()));
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("recursivity").item(0).getTextContent()));
                    SpAtri.enQueue(Integer.parseInt(elm.getElementsByTagName("reindex").item(0).getTextContent()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * metodo que retorna una lista de atributos del spiderbot puestos en el xml
     * 
     * @return 
     */
    public ListaSdoble getSpAtri(){
        return this.SpAtri;
    }
    
    /**
     * retorna la lista de los urls targets en el xml
     * @return 
     */
    public ListaUrls getUrls(){
        return this.Urls;
    }
}
