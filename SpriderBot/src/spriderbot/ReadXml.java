/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriderbot;

import DataBase.Lista;
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
    private Lista Urls;
    private Lista SpAtri;
    
    public ReadXml(){
        Urls= new Lista();
        SpAtri= new Lista();
    }
    
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
                    Urls.insertHead(elm.getElementsByTagName("url").item(0).getTextContent());
                    Urls.insertHead(elm.getElementsByTagName("url").item(1).getTextContent());
                }
            }
            else{
                NodeList lista = docu.getElementsByTagName("spider");
                Node nodoL = lista.item(0);
                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                    Element elm= (Element)nodoL;
                    SpAtri.insertHead(Integer.parseInt(elm.getElementsByTagName("maxthreads").item(0).getTextContent()));
                    SpAtri.insertHead(Integer.parseInt(elm.getElementsByTagName("recursivity").item(0).getTextContent()));
                    SpAtri.insertHead(Integer.parseInt(elm.getElementsByTagName("reindex").item(0).getTextContent()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Lista getSpAtri(){
        return this.SpAtri;
    }
    
    public Lista getUrls(){
        return this.Urls;
    }
}
