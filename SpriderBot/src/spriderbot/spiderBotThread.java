/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spriderbot;

import Logica.ListaSdoble;
import java.io.IOException;
import java.net.Socket;

/**
 * clase para ir agarrando cada una de los links y extrayendo las palabras
 * @author osboxes
 */
public class spiderBotThread extends Thread{
    
    private Socket socket;
    private String Url;
    private ListaSdoble UrlH;
    
    /**
     * metodo para crear la coneccion y empezar analizar las urls targets 
     * proveniente del xml y de esta misma forma va ingresando los 
     * otros urls que se encuentran al analizar las urls targets.
     */
    public spiderBotThread(String Url){
        this.Url= Url;
    }
    
    
    /**
     * <***falta cambiar***>
     * thread que va leyendo la pagian y extrayendo las palabras encontras en 
     * este misma, las encolando en la lista de keywords y 
     */
    @Override
    public void run(){
        try{
            socket= new  Socket(Url, 80);
            System.out.println(socket.getInetAddress());
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }    
    }
    
    /**
     * devuelve la lista de palabras que se encontraron en el url seleccionado
     * @return 
     */
    public ListaSdoble getHijos(){
        return UrlH;
    }
}
