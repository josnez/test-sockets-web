
package org.example.src.logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteHilo extends Thread{

    private Socket host;
    private DataOutputStream datosSalida;
    private DataInputStream datosEntrada;
    public static int NUM_CLIENTES = 0;
    private int clienteNo;

    public String mensaje;
    
    public ClienteHilo(Socket c) {
        host = c;
        NUM_CLIENTES++;
        clienteNo = NUM_CLIENTES;
    }

    @Override
    public void run() {
        mensaje = "Hola "+ clienteNo + "!";
        boolean flag = true;
        
        try {
            // Capturo el flujo de salida y lo asocio al dato de salida
            datosEntrada = new DataInputStream(host.getInputStream());
            datosSalida = new DataOutputStream(host.getOutputStream());
            // opero con los mensajes
            while (flag) {
                datosSalida.writeUTF(mensaje); // ESTE ES EL PROTOCOLO
                String input = datosEntrada.readUTF();
                System.out.println(input);
            }
            // Se cierra todo
            datosSalida.close();
            host.close();
            
        } catch (IOException ex) {            
        }        
        
    }
    
    
    
    
}
