/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xmls;

import Logica.ListaKeywords;
import Logica.ListaSdoble;
import Logica.Nodo;
import Logica.NodoKeyword;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * clase para hacer el xml que contiene las palabras puestas en la 
 * lista de keywords, y se utiliza para enviarla al spider engine
 * @author osboxes <-------------nombre de maquina virtual de ubuntu, 
 * create by ellioth>
 */
public class CrearXml {
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder Builder;
    private Document doc;
    private Element root;
    private Element palabra;
    private Element pDato;
    private Element Url;
    private Element Cont;
    
    /**
     * en el constructor llama, inicializa todo para ir creando el xml
     * @param keywords 
     * lista que se le ingresa del tipo keywords que contiene todas las 
     * palabras
     */
    public CrearXml( ListaKeywords keywords){
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            Builder = docFactory.newDocumentBuilder();
            // root elements
            doc = Builder.newDocument();
            root = doc.createElement("lista_busquedas");
            doc.appendChild(root);
            NodoKeyword tmp= (NodoKeyword)keywords.getHead();
            for(int i=0; i<keywords.lengthLista(); i++){
                root.appendChild(setBlockPalabra(doc, (String)tmp.getData(), tmp.getPadres(), tmp.getCont()));
                tmp= (NodoKeyword)tmp.getNext();
            }
            // write the content into xml file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("KeyWords.xml"));

            // Output to console for testing
            //StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
              pce.printStackTrace();
        } catch (TransformerException tfe) {
              tfe.printStackTrace();
        }
    }
    
    /**
     * metodo para hacer el nodo xml que contendra todo lo perteneciente al 
     * keyword
     * @param doc el docuemnto en que se va creando todo
     * @param id un id para parametrizar y diferenciar los keywords
     * @param ListaPadres lista que contiene a los padres urls
     * @param ListaCont lista que contiene a la cantidad de veces que se 
     * encontro una palabra en un padre url
     * @return retorna el nodo xml que se creo en este metodo
     */
    public Node setBlockPalabra(Document doc, String id, ListaSdoble ListaPadres, ListaSdoble ListaCont){
        palabra= doc.createElement("Palabra");
        palabra.setAttribute("dato", id);
        Nodo padres= ListaPadres.getHead();
        Nodo contador= ListaCont.getHead();
        while(padres!=null){
            setPadres(doc, palabra, padres, contador);
            padres= padres.getNext();
            contador= contador.getNext();
        }
        return palabra;
    }
    
    /**
     * establece los atributos del nodo que se va creando en el metodo
     * setBlockPalabra
     * @param doc recibe el documento donde se va creando todo el xml 
     * @param palabra nodo al cual se le van a ir ingresando los atributos 
     * obtenidos de las listas padres y cont del metodo setBlockPalabra
     * @param padre recibe al Nodo padre pertenciente a la lista padre
     * @param contador recibe al Nodo contador pertenciente a la lista cont
     */
    public void setPadres(Document doc,Node palabra, Nodo padre, Nodo contador){
        Url= doc.createElement("Url");
        Url.appendChild(doc.createTextNode((String)padre.getData()));
        palabra.appendChild(Url);
        Cont= doc.createElement("cantidad_aparecido");
        Cont.appendChild(doc.createTextNode(String.valueOf((int)contador.getData())));
        palabra.appendChild(Cont);
        
    }
    
    /**
     * casos de prueba
     * @param args 
     *
    public static void main(String[] args) {
        ListaKeywords l= new ListaKeywords();
        l.enQueue("hola","www.wikipedia.org/java/oracle/sunMicroSystem");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.enQueue("mundo", "www.wikipedia.org/java/oracle/Micro_Sun_System");
        l.upCount();
        l.upCount();
        l.setPadre("www.stackoverflow.net/ask/Hola_mundo");
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.enQueue("nueva", "www.wikipedia.org/java/oracle/sun_Micro_System");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.google.com/pq?=/?como_hacer_nueva_carpeta");
        l.upCount();
        l.upCount();
        l.upCount();
        l.enQueue("lista", "www.wikipedia.org/java/oracle/sun_Micro_System");
        l.upCount();
        l.upCount();
        l.upCount();
        l.setPadre("www.oracleSun.org/docs/documentation/Java_8/Listas");
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        l.upCount();
        CrearXml prueba= new CrearXml(l);
    }*/
    
}
