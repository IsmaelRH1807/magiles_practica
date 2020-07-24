package ec.edu.epn.controlador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPublicacion {
	
	Publicacion p;
	
	@Test
	public void precioTotalTest() {
		p = new Publicacion();
		int actual = p.PrecioTotal(15, 3);
		int espected = 45;
		assertEquals(espected, actual);
	}
}
