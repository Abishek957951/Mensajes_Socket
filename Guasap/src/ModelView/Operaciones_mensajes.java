/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abish
 */
public class Operaciones_mensajes {
    
    Socket conexion = null ;
    ServerSocket server = null;
    int socket_mio = 0;
    
    public void intentar_conexion(String ip, int puerto_yo, int puerto_otro){
        try {
            System.out.println(puerto_otro);
            System.out.println(ip);
            Socket socket = new Socket(ip, puerto_otro); 
            if(socket.isConnected()){
                conexion = new Socket(ip,puerto_otro);
                socket_mio = puerto_yo;
                Guasap.CerrarInicio();
                Guasap.MostrarPantalla();   
            }              
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a esta Ip", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectException e) {
            JOptionPane.showMessageDialog(null, "Este puerto no esta disponible o la Ip no esta disponible", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error en uno de los puertos de salida o entrada", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error imprevisto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void enviar_texto(String texto){
        try {
            DataOutputStream flujo = new DataOutputStream(conexion.getOutputStream());
            flujo.writeUTF(texto);
            flujo.close();
        } catch (IOException ex) {
            Logger.getLogger(Operaciones_mensajes.class.getName()).log(Level.SEVERE, "an error ocurred", ex);
        }
    }
    
    public int recibir_texto(){
      return socket_mio; 
    }
    
    public void enviar_imagen(){
        try {
            byte[] imagen = Files.readAllBytes(Paths.get("image.jpg"));
            OutputStream flujo = conexion.getOutputStream();
            flujo.write(imagen);
        // metodos para la transmision de multimedia
            flujo.close();
        } catch (IOException ex) {
            Logger.getLogger(Operaciones_mensajes.class.getName()).log(Level.SEVERE, "an error ocurred", ex);
        }
    }
    /*
    public void recibir_imagen(){
        try {
            while(true){
            DataInputStream flujo = new DataInputStream(socket_mio.getInputStream());
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nread;
            byte[] data = new byte[1024];
            while((nread = flujo.read(data, 0, data.length)) != -1){
                buffer.write(data,0,nread);
            }
            buffer.flush();
            byte[] imagen = buffer.toByteArray();
            FileOutputStream outputStream = new FileOutputStream("imagen_recibida.jpg");
            outputStream.write(imagen);
            outputStream.close();
            flujo.close();
            server.close();
            }    
        } catch (IOException ex) {
            Logger.getLogger(Operaciones_mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    

    
}
