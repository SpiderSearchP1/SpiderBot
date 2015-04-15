package TCP_IP;

/**
 *
 * @author Ellioth
 */


import Logica.ListaKeywords;
import Logica.ListaSdoble;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente extends Thread{
    
    private Socket socket;
    private DataInputStream Datos_Entrada;
    private DataOutputStream Datos_Salida;
    private int puerto;
    private String ip;
    private String mensaje;
    private  int id;
    private ListaSdoble InDatos;
    
    public Cliente(String ip, int puerto){
        mensaje="";
        this.ip= ip;
        this.puerto= puerto;
        InDatos= new ListaKeywords();
    }
    
    /**
     * metodo thread que arranca el thread y hace que este recibiendo 
     * los mensajes que le manda el servidor.
     */
    @Override
    public void run(){
        try{
            socket= new Socket(ip, puerto);
            Datos_Entrada= new DataInputStream(socket.getInputStream());
            Datos_Salida= new  DataOutputStream(socket.getOutputStream());
            //if(mensaje.length()>0){}
            while(!mensaje.equals("out")){
                InDatos.enQueue(Datos_Entrada.readUTF());
                /**System.out.println("escriba un mensaje");
                Datos_Salida.writeUTF((new Scanner(System.in)).nextLine());
                Datos_Salida.flush();
                System.out.println("usuario"+ id + "mensaje enviado");
                mensaje= Datos_Salida.toString();*/
            }
            Datos_Entrada.close();    
            Datos_Salida.close();
            socket.close();
        }catch(IOException e){
            System.out.print(e);
        }
    }
    
    /**
     * retorna la lista de datos que va a recibir las busquedas y demas 
     * datos que se puedan recibir de parte del servidor.
     * @return 
     */
    public ListaSdoble extracInData(){
        return InDatos;
    }
    
    /**
     * recibe un parametro que es un mensaje Y envia por medio del 
     * socket el mensaje.
     * @param mensaje 
     */
    public void sendMsj(String mensaje){
        try{
            this.mensaje=mensaje;
            Datos_Salida.writeUTF(this.mensaje);
            Datos_Salida.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * devuelve el estado del cliente deacuerdo a si este s pudo 
     * conectar o no.
     * @return booleano
     */
    public boolean getStateClient(){
        return socket.isClosed();
    }
    
    /**
    public static void main(String[] args) {
        Cliente id= new Cliente("192.168.1.104", 5005);
        id.start();
    }*/
    
}
