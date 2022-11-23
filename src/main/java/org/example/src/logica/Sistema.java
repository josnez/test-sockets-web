
package org.example.src.logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private boolean conectarActivo;

    public List<ClienteHilo> clientes;
       
    public Sistema() {
        puerto = 5000;
        conectarActivo = true;
        clientes = new ArrayList<>();
    }

    public void conectar() throws IOException {
                       
        // Crear el servidor
        server = new ServerSocket(puerto);
        
        while(conectarActivo){
            //Esperar a que alguien se conecte        
            cliente = server.accept();                    
            // Alguien se conectó
            ClienteHilo c = new ClienteHilo(cliente);
            clientes.add(c);
            c.start();
        }
    }
    
}
