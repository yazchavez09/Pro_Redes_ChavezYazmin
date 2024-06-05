package Archivos;

import java.io.IOException;
import java.io.PrintStream;

public class Ejercicios {

    public static String entradaDeDatos() {
        StringBuilder cadena = new StringBuilder();
        try {
            int Byte;
            while ((Byte = System.in.read()) != '\n') {
                if (Byte != 13) { // Ignorar el retorno de carro (carriage return)
                    cadena.append((char) Byte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cadena.toString();
    }

    // M�todo para verificar si el texto es un n�mero (entero o flotante) utilizando la tabla ASCII
    public static Object verificarNumero(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null; // No es un n�mero v�lido
        }

        boolean esEntero = true;
        boolean puntoEncontrado = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == '.') {
                if (puntoEncontrado || i == 0 || i == texto.length() - 1) {
                    return null; // M�s de un punto, punto al inicio, o punto al final no es v�lido
                }
                puntoEncontrado = true;
                esEntero = false;
            } else if (c < '0' || c > '9') {
                return null; // Caracter no num�rico encontrado
            }
        }

        if (esEntero) {
            return Integer.parseInt(texto); // N�mero entero
        } else {
            return Float.parseFloat(texto); // N�mero de punto flotante
        }
    }
}

//public class Ejercicios {

	//static PrintStream ps = new PrintStream(System.out);
	
	//static String entradaDeDatos() {
		
	//	String cadena = "";
		
		//try {
			
		//	int Byte = -1;
			
			//while ((Byte = System.in.read()) != '\n') {
				//if (Byte != 13)
			//		cadena += (char) Byte;
		//	}
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
		
		
		//return cadena;
	//}
	
	//static String Ej1() {
		
		//ps.println("Escriba: ");
		//String texto = entradaDeDatos();
		
		//return texto;
	//}
	


//}
