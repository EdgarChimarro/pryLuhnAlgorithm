/* 
 * AlgoritmoLuhn.java 
 * 8/12/2017
 * Copyright 2017 TCS.
 * Todos los derechos reservados.
 */
package luhn;

/**
 * <b> Validacion de Tarjetas usando el algorithmo de Luhn. </b>
 * 
 * @author Edgar Chimarro
 * @version $1.0$
 */
public class AlgoritmoLuhn {

	public static boolean esTarjetaValidaLuhn(String strNumeroTarjeta) {

		int intSuma = 0;
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
		return esTarjetaValida;
	}

	public static void main(String[] args) {
		String cardNumber = "4012888888881881";
		boolean isValidCard = false;
		isValidCard = esTarjetaValidaLuhn(cardNumber);
		if (isValidCard) {
			System.out.println("Credit Card ".concat(cardNumber).concat(" is valid"));
		} else {
			System.out.println("Credit Card ".concat(cardNumber).concat(" is not valid"));
		}
	}

}
