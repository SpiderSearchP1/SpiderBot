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
import Logica.NodoUrl;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

/**
 * clase para el spiderbot, esta hace que el se lea el xml que contiene 
 * los urls targets y se empize a leer las paginas.
 * @author osboxes <----------------nombre de la amaquina virtual en ubuntu
 */
public class SpiderBot<dp> extends HTMLEditorKit.ParserCallback{

    private int maxthreads;
    private int recursivity;
    private int reindex;
    private ReadUrls lectorXml;
    private ListaUrls listUrls;
    private NodoUrl search;
    private String URl;
    private int depth=1;
    
    
    /**
     * constructor de el spider bot, crea una instancia del lector de xml 
     * y hace que se lea la informacion de este xml para empezar a hacer 
     * busquedas
     * @throws java.io.IOException
     */
    public SpiderBot() throws IOException{
        lectorXml= new ReadUrls();
        lectorXml.readAll(1);
        lectorXml.readAll(0);
        extrac(lectorXml.getSpAtri());
        listUrls=lectorXml.getUrls();
        search=listUrls.getHead();
        int maxRecur=0;
        int limit=listUrls.getLenght();
        while(maxRecur<limit){
            getLinks((String) search.getNext().getData());
            search=(NodoUrl) search.getNext();
            maxRecur++;
        }
        depth++;
        listUrls.print();
    }
    
    /**
     * metodo que recibe una lista doble enlazada simple y saca los atributos 
     * para el spiderbot
     * @param list 
     */
    private void extrac(ListaSdoble list){
        Nodo tmp= list.getHead();
        reindex= (int)tmp.getNext().getNext().getData();
        recursivity= (int)tmp.getNext().getData();
        maxthreads=(int)tmp.getData();
    }
    
    /**
     * metodo para hacer que segun como entre el link extraido desde la pagina
     * hace que este pueda ser ingresado a la lista de manera correspondiente
     * de acuerdo a la gramatica de paginas web.
     * @param url String de la url donde se estan extrayendo los links.
     * @param link String del dato extraido desde la pagina web.
     * @return retorna una String que contiene un url valida.
     */
    private String makeAbsolute(String url, String link) {
        if (link.matches("http://.*"))
            return link;
        else if(link.matches("//.*"))
            return "http:"+link;
        else if(link.matches("#.*"))
            return url;
        else if (link.matches("/.*") && url.matches(".*$[^/]"))
            return url + link;
        else if (link.matches("[^/].*") && url.matches(".*[^/]"))
            return url +  link;
        else if (link.matches("/.*") && url.matches(".*[/]"))
            return url + link;
        else if (link.matches("/.*") && url.matches(".*[^/]"))
            return url + link;
        else
            throw new RuntimeException("Cannot make the link absolute. Url: " + url+ " Link " + link);
    }
    
    /**
     * metodo para ir extrayendo los links desde las paginas webs
     * @param Url recibe un String que es la pagina web.
     * @throws IOException excepcion en caso de fallar la entrada o 
     * salida de datos
     */
    private void getLinks(String Url) throws IOException {
        Reader r = null;
        try{
            URL u = new URL(Url);
            InputStream in = u.openStream();
            r = new InputStreamReader(in);
            ParserDelegator hp = new ParserDelegator();
            hp.parse(r, new HTMLEditorKit.ParserCallback() {
                public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos){
                    // System.out.println(t);
                    if(t == HTML.Tag.A){
                        Enumeration attrNames = a.getAttributeNames();
                        StringBuilder b = new StringBuilder();
                        cutUrl(Url);
                        while(attrNames.hasMoreElements()){
                            Object key = attrNames.nextElement();
                            if("href".equals(key.toString())) {
                                //&& a.getAttribute(key).toString().substring(0,7).equals("http://")
                                listUrls.enQueue_none_repeat(makeAbsolute(cutUrl(Url), a.getAttribute(key).toString()),depth);
                            }
                        }
                    }
                }
            }, true);
        }finally{
            if(r != null)
                r.close();
        }
    }
    
    /**
     * metodo para cortar el url y no tomar en cuenta lo que continua luego 
     * del .com, .net, .org y asi con todos.
     * @param url recibe un String que es el url que se va a cortar
     * @return retorna un String del url cortado
     */
    private String cutUrl(String url){
        int cant=0;
        int x=0;
        int y=1;
        String slash="/";
        String tmp="";
        StringBuilder contenedor= new StringBuilder();
        while(cant<3){
            if(url.substring(x, y).equals(slash))
                cant++;
            contenedor.append(url.substring(x, y));
            x++;
            y++;
        }
        tmp=contenedor.toString().substring(0, contenedor.length()-1);
        return tmp;
    }
    
    public static void main(String[] args) throws IOException {
        SpiderBot nuvo = new SpiderBot();
    }
}
