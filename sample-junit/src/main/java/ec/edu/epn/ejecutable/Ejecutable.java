package ec.edu.epn.ejecutable;

import ec.edu.epn.vistas.JFramePublicacion;

public class Ejecutable {
    
    public static void main(String[] args) {
       
    	System.out.println("********************************");
    	System.out.println("Metodologías Ágiles");
    	System.out.println("Pruebas con de integración con Jenkins y GitHub\n\n");
    	System.out.println("INTEGRANTES: BRYAN ORTUÑO - ISMAEL RIVAS\n\n");
    	System.out.println("CONEXIÓN EXITOSA\n");
    	System.out.println("********************************");
    	
       String nombre = "Bryan Galindo"; 
       String cedula = "1723695887  ";
       
       
        JFramePublicacion jpub = new JFramePublicacion(nombre,cedula);
        jpub.setVisible(true);
        
    }
}
