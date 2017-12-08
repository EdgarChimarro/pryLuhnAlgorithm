/* 
 * testAlgoritmoLuhn.java 
 * 8/12/2017
 * Copyright 2017 TCS.
 * Todos los derechos reservados.
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <b> Clase de pruebas para la construccion del Algoritmo Luhn. </b>
 * 
 * @author Edgar Chimarro
 * @version $1.0$
 */
public class testAlgoritmoLuhn {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * <b> Clase refactoring de codigo. </b>
	 * <p>
	 * [Author Edgar Chimarro, 8/12/2017]
	 * </p>
	 */
	@Test
	public void testRefactor() {

		int intSuma = 0;
		String strNumeroTarjeta = "4012888888881881";
		int intDigitos = strNumeroTarjeta.length();
		int intDigitoActual;
		int intParidad = intDigitos % 2;
		int auxiliar = 1;
		boolean esTarjetaValida = false;
		for (int i = 0; i < strNumeroTarjeta.length(); i++) {
			intDigitoActual = Integer.parseInt(strNumeroTarjeta.substring(i, auxiliar));
			if (i % 2 == intParidad) {
				intDigitoActual = intDigitoActual * 2;
				if (intDigitoActual > 9) {
					intDigitoActual = intDigitoActual - 9;
				}
			}
			intSuma += intDigitoActual;
			auxiliar++;
		}
		System.out.println("Resultado modulo: " + intSuma % 10);
		esTarjetaValida = (intSuma % 10) == 0 ? true : false;
		System.out.println("Resultado Verificacion:" + esTarjetaValida);

		assertEquals(true, esTarjetaValida);

	}

	/**
	 * <b> Test de recuperacion de los digitos de la Tarjeta. </b>
	 * <p>
	 * [Author Edgar Chimarro, 8/12/2017]
	 * </p>
	 */
	@Test
	public void testExtraerNumero() {
		String strNumeroTarjeta = "79927398713";
		int numeroExtraido;
		for (int i = 0; i < strNumeroTarjeta.length(); i++) {
			numeroExtraido = strNumeroTarjeta.charAt(i);
			if (i == 0) {
				assertEquals(7, numeroExtraido);
			}
		}
	}

}
