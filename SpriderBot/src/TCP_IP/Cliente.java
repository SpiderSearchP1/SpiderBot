package TCP_IP;

/**
 *
 * @author Ellioth
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread{
    
    private Socket socket;
    private DataInputStream Datos_Entrada;
    private DataOutputStream Datos_Salida;
    private int puerto;
    private boolean bandera;
    private String ip;
    private String mensaje;
    private  int id;;
    
    public Cliente(String ip, int puerto){
        mensaje="";
        this.ip= ip;
        bandera= true;
        this.puerto= puerto;
        this.id= id;
    }
    
    @Override
    public void run(){
        try{
            socket= new Socket(ip, puerto);
            //Datos_Entrada= new DataInputStream(socket.getInputStream());
            Datos_Salida= new  DataOutputStream(socket.getOutputStream());
            //if(mensaje.length()>0){}
            while(!mensaje.equals("out")){
                System.out.println("escriba un mensaje");
                Datos_Salida.writeUTF((new Scanner(System.in)).nextLine());
                Datos_Salida.flush();
                System.out.println("usuario"+ id + "mensaje enviado");
                mensaje= Datos_Salida.toString();
            }
            //Datos_Entrada.close();    
            Datos_Salida.close();
            socket.close();
        }catch(IOException e){
            System.out.print(e);
        }
    }
    
    public void sendMsj(String mensaje){
        try{
            this.mensaje=mensaje;
            Datos_Salida.writeUTF(this.mensaje);
            Datos_Salida.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setBandera(boolean bandera){
        this.bandera= bandera;
    }
    /**
    public static void main(String[] args) {
        Cliente id= new Cliente("192.168.1.104", 5005);
        id.start();
    }*/
    
}
