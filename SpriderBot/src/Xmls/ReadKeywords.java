/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xmls;

import Logica.ListaKeywords;
import Logica.NodoKeyword;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author osboxes
 */
public class ReadKeywords {
    
    private DocumentBuilder Dbuilder;
    private DocumentBuilderFactory Dfactory;
    private Document docu;
    private ListaKeywords BaseD;
    private NodoKeyword NodoBaseD;
    
    public ReadKeywords(){
        BaseD= new ListaKeywords();
    }
    
    public ListaKeywords readDatos(){
        try{
            Dfactory = DocumentBuilderFactory.newInstance();
            Dbuilder= Dfactory.newDocumentBuilder();
            docu= Dbuilder.parse("web_pages.xml");
            docu.getDocumentElement().normalize();
            NodeList Lista = docu.getElementsByTagName("Palabra");
            int indice=0;
            Node nodoPalabra= Lista.item(indice);
            while(indice<Lista.getLength()){
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
