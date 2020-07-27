package ec.edu.epn.ejecutable;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ec.edu.epn.controlador.ListaViaje;
import ec.edu.epn.controlador.Viaje;
import ec.edu.epn.vistas.JFramePublicacion;

public class Ejecutable {
	static ListaViaje list = new ListaViaje();;
	
    public static void main(String[] args) {
       
    	System.out.println("********************************");
    	System.out.println("Metodologías Ágiles");
    	System.out.println("Pruebas con de integración con Jenkins y GitHub\n\n");
    	System.out.println("INTEGRANTES: BRYAN ORTUÑO - ISMAEL RIVAS\n\n");
    	System.out.println("CONEXIÓN EXITOSA\n");
    	System.out.println("********************************");
    	
       String nombre = "Bryan Galindo"; 
       String cedula = "1723695887  ";
       
       SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = "27/08/2019";
		try {
			Date fe = sd.parse(fecha);
			list.agregarViaje(new Viaje("0120", "Cuenca", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));
			list.agregarViaje(new Viaje("0263", "Quito", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));
			list.agregarViaje(new Viaje("0826", "Azogues", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));

			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.contarViajes();
      
        /*JFramePublicacion jpub = new JFramePublicacion(nombre,cedula);
        jpub.setVisible(true);*/
        
    }
}
