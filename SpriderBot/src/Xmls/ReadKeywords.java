/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xmls;

import Logica.ListaKeywords;
import Logica.NodoKeyword;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
            docu= Dbuilder.parse("KeyWords.xml");
            docu.getDocumentElement().normalize();
            NodeList Lista = docu.getElementsByTagName("Palabra");
            //for (int indiceNpalabra=0; indiceNpalabra<Lista.getLength(); indiceNpalabra++){
                Node nodoPalabra= Lista.item(0);
                if (nodoPalabra.getNodeType()==Node.ELEMENT_NODE){
                    Element nodo= (Element) nodoPalabra;
                    BaseD.enQueue(nodo.getAttribute("dato"),nodo.getElementsByTagName("Url").item(0).getTextContent());
                    NodoBaseD= (NodoKeyword)BaseD.getTail();
                    System.out.println(nodo.getElementsByTagName("cantidad_aparecido").item(0).getTextContent()+ "cantida de urls del padre: "+ nodo.getElementsByTagName("Urls").getLength());
                    //NodoBaseD.setCount(nodo.getElementsByTagName("cantidad_aparecido").item(0).getTextContent());
                    for (int indiceUrls=1; indiceUrls<nodo.getElementsByTagName("Urls").getLength(); indiceUrls++){
                        System.out.println("entra en for 2");
                        NodoBaseD.setPadre(nodo.getElementsByTagName("Url").item(indiceUrls).getTextContent());
                        NodoBaseD.setCount(nodo.getElementsByTagName("cantidad_aparecido").item(indiceUrls).getTextContent());
                    }
                }
            //}
        }catch(Exception e){
            e.printStackTrace();
        }
        BaseD.print();
        return BaseD;
    }
    
    public static void main(String[] args) {
        System.out.println("prueba ");
        ReadKeywords prueba = new ReadKeywords();
        prueba.readDatos();
    }
}
