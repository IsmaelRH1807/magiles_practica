package ec.edu.epn.ejecutable;

import ec.edu.epn.vistas.JFramePublicacion;

public class Ejecutable {
    
    public static void main(String[] args) {
       
       String nombre = "Bryan Galindo"; 
       String cedula = "1723695887";
        JFramePublicacion jpub = new JFramePublicacion(nombre,cedula);
        jpub.setVisible(true);
        
    }
}
