/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

import View.Pantalla;
import static View.Pantalla.instancia;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author abish
 */
public class Server extends Observable implements Runnable {
    
    private int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        ServerSocket server = null;
        Socket socket = null;
        DataInputStream input;

        try {
            server = new ServerSocket(port);
            while (true) {
                socket = server.accept();
                input = new DataInputStream(socket.getInputStream());
                String message = input.readUTF();
                this.setChanged();
                this.notifyObservers(message);
                this.clearChanged();
                instancia.agregar_labels(message);
                socket.close();
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: de errores" + e);
        }

    }
    

    
}
