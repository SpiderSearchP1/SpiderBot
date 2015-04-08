package TCP_IP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



/**
 *
 * @author Ellioth
 */
public class MultiServer extends Thread{
    
    private DataInputStream InputData;
    private DataOutputStream OutputData;
    private String MessageIn;
    private Socket socket;
    private int ID;
    public boolean bandera=true;
    
    public MultiServer(Socket socket , int ID){
        this.socket= socket;
        this.ID=ID;
        try{
            InputData= new DataInputStream(socket.getInputStream());
            OutputData= new DataOutputStream(socket.getOutputStream());
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void desconectar(){
        try{
            socket.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void run(){
        System.out.println("entro en el run");
        while(bandera){
            try{
                MessageIn=InputData.readUTF();
                if (MessageIn.equals("out")){
                    System.out.println("Cliente ID:"+ ID+ ", socket:"+ socket+"; se ha desconectado");
                    desconectar();
                    bandera=false;
                }
                else if(MessageIn.equals("getID")){
                    enviarDato(String.valueOf(ID));
                }
                else {
                    System.out.println("Cliente ID:"+ ID+ ", socket:"+ socket+"; envia mensaje ");
                    try{
                        System.out.print(": "+MessageIn);}
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }catch(IOException e){
                    System.out.println("Player id: "+ID+e.getMessage());
                    bandera=false;

            }
        }
    }
    
    public void enviarDato( String mensaje){
        try{
            OutputData.writeUTF(mensaje);
            System.out.println("resultado = "+ mensaje);
        }catch(IOException e){
            System.out.println("error con Cliente ID: "+ID+"descripcion: "+"\n" +e.getMessage());
        }
    }
}