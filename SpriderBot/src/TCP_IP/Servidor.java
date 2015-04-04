package TCP_IP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ellioth
 */



public class Servidor {
    //private static final int puerto= 3601;
    private ServerSocket servidor;
    private Socket socket;
    private boolean listening;
    private int ID;
    private int puerto;

    public Servidor() throws IOException{
        listening=true;
        ID=1;
        puerto=5005;
        try{
            servidor = new ServerSocket(puerto);
            System.out.println("esperando cliente");
            while (listening){
                socket= servidor.accept();
                System.out.print("socket de cliente"+ ID +" :" +socket);
                ((MultiServer)new MultiServer(socket, ID )).start();
                ID++;
            }
        }catch(IOException e){
                System.out.println(e.getMessage());
        }	
    }
    public int getPuerto(){
        return puerto;
    }
    /**
    public static void main(String [] args) throws IOException{
            Servidor SR= new Servidor();
    }*/
    
}

