/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

/**
 *
 * @author abish
 */

import View.Enlace;
import View.Pantalla;

public class Guasap {
    
    public static Enlace enlace = new Enlace();
    static Pantalla pantalla = new Pantalla();
    static Operaciones_mensajes om = new Operaciones_mensajes();
    
    public static void main(String[] args){
        enlace.setVisible(true);
        enlace.setLocation(350,50);
    }
    
//Funciones de operaciones de abrir y cerrar los formularios
    public static void MostrarInicio() {
        enlace.setVisible(true);
        enlace.setLocation(350,50);
    }
    public static void CerrarInicio() {
        enlace.setVisible(false);
    }
    public static void MostrarPantalla() {
        pantalla.setVisible(true);
        pantalla.setLocation(350,50);
    }
    public static void CerrarPantalla() {
        pantalla.setVisible(false);
    }
    
    
    public static void try_connection(String ip, int puerto_yo, int puerto_otro){
        om.intentar_conexion(ip,puerto_yo,puerto_otro);
    }
    public static void send_text(String mensaje){
        om.enviar_texto(mensaje);
    }
    public static int receive_text(){
        return om.recibir_texto();
    }
    public static void send_image(){
        om.enviar_imagen();
    }
    /*
    public static void receive_image(){
        om.recibir_imagen();
    }
*/
    
    
    
    
    
}
