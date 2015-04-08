/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logica.ListaSdoble;
import TCP_IP.Cliente;

/**
 *
 * @author osboxes
 */
public class interData {
    private Cliente client;
    private boolean stateConn=true;
    
    public void strartCliente(String ip, int puerto){
        try{
            client= new Cliente(ip, puerto);
            new Thread(client).start();
            stateConn=client.getStateClient();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Cliente getCliente(){
        return client;
    }
    
    public boolean get_state(){
        return stateConn;
    }
    
    public void sendMsj(String msj){
        client.sendMsj(msj);
    }
    
    public ListaSdoble getDatos(){
        return client.extracInData();
    }
}
