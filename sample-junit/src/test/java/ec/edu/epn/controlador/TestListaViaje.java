package ec.edu.epn.controlador;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.BeforeClass;
import org.junit.Test;

public class TestListaViaje {
	
	private static ListaViaje list;
	
	@BeforeClass
	public static void beforeListaViajeTest() {
		list = new ListaViaje();
		
	}

	
	@Test
	public void TestAgregar() {

		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = "27/08/2019";
		try {
			Date fe = sd.parse(fecha);
			//list.agregarViaje(new Viaje("0120", "Cuenca", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));
			list.agregarViaje(new Viaje("0263", "Quito", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));
			list.agregarViaje(new Viaje("0826", "Azogues", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40"));
			assertTrue(list.agregarViaje(new Viaje("0120", "Cuenca", "Guayaquil", fe , 4, 4, 17, "Susana Perez", "Mazda 3", "ABC465","12:40", "2:40") )) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void TestContarViajes() {
	
		assertEquals(3,list.contarViajes());
		
	}
	
	@Test
	public void TestBajarDisponibilidad() {
		
		assertTrue(list.bajarDisponibilidad("0263",4));
	}
	
	@Test
	public void TestgenerarIDNuevoViaje() {
		
		assertEquals(4,list.generarIDNuevoViaje().length());
	}
		
}
