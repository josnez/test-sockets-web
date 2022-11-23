package org.example.src.presentacion;


import org.example.src.logica.Sistema;

import java.io.IOException;


public class Modelo {

    private Sistema miSistema;

    public Sistema getMiSistema() {
        if(miSistema == null){
            miSistema = new Sistema();
        }
        return miSistema;
    }
    
    
    
    public void iniciar() {
        try {
            System.out.println("Estableciendo conexión...");
            getMiSistema().conectar();
            System.out.println("Finalizando!");
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
}
