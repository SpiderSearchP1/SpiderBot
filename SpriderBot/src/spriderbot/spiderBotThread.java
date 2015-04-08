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
 *
 * @author osboxes
 */
public class spiderBotThread extends Thread{
    
    private Socket socket;
    private String Url;
    private ListaSdoble UrlH;
    /**
     * metodo para crear la coneccion y empezar analizar las urls targets 
     * proveniente del xml y de esta misma forma va ingresando los 
     * otros urls que se encuentran al analizar las urls targets
     */
    
    public spiderBotThread(String Url){
        this.Url= Url;
    }
    
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
    
    public ListaSdoble getHijos(){
        return UrlH;
    }
}
