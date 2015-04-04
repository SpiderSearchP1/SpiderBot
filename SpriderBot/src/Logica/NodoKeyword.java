/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *  metodo para ir creando nodos del tipo Keyword para la bases 
 * de datos que almacenara todas estas a su vez.
 * @author Ellioth
 */
public class NodoKeyword <dp> extends Nodo{

    private ListaSdoble Urlpadre;
    private ListaSdoble countPpage;
    private Nodo indiceCt;
    
    /**
     * contructor que recibe un pData que seria lo que se quiere ingresar
     * en este caso la palabra; recibe un Url padre que nos indica de que 
     * url proviene esa palabra.
     * @param pData
     * @param Urlpadre 
     */
    public NodoKeyword(dp pData, String Urlpadre) {
        super(pData);
        this.Urlpadre= new ListaSdoble();
        this.countPpage= new ListaSdoble();
        this.Urlpadre.enQueue(Urlpadre);
        this.countPpage.enQueue(1);
        indiceCt= this.countPpage.getHead();
    }
    
    @Override
    public Object getData() {
        return super.getData(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrev(Nodo pNodo) {
        super.setPrev(pNodo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNext(Nodo pNodo) {
        super.setNext(pNodo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getPrev() {
        return super.getPrev(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getNext() {
        return super.getNext(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * metodo para ingresar un nuevo padre a la keyword.
     * @param Urlpadre dato de entra del Url padre
     */
    public void setPadre(String Urlpadre){
        indiceCt.setNext(new Nodo(0));
        indiceCt= indiceCt.getNext();
        this.Urlpadre.enQueue(Urlpadre);
        upCount();
    }
    
    /**
     * obtiene los padres urls del nodo
     * @return Urlpadre;
     */
    public ListaSdoble getPadres(){
        return Urlpadre;
    }
    
    public ListaSdoble getCont(){
        return countPpage;
    }
    /**
     * metodo para aumentar la cuenta de la cantidad de veces que 
     * se encontro la palabra en la pagina indicada.
     */
    public void upCount(){
        indiceCt.setData((int)indiceCt.getData()+1);
    }
    
    public void setCount(dp i){
        indiceCt.setData(i);
    }
    
    /**
     * retorna la cantidad de padres que existen en un nodo
     * @return 
     */
    public int LengthP(){
        Nodo tmp= Urlpadre.getHead();
        int i=0;
        while(tmp!=null){
            i++;
            tmp=tmp.getNext();
        }
        return i;
    }
    
    /**
     * metodo pra imprimir el ocntenido del nodo, en este caso imprime
     * los padres del nodo y su cantidad de veces aparecida.
     */
    public void printPadre(){
        Nodo tmp1= Urlpadre.getHead();
        Nodo tmp2= countPpage.getHead();
        while(tmp1!=null || tmp2!=null){
            System.out.println(tmp1.getData()+"..Cantidades de veces Encontrada la palabra: "+tmp2.getData());
            tmp1= tmp1.getNext();
            tmp2= tmp2.getNext();
        }
    }
}
