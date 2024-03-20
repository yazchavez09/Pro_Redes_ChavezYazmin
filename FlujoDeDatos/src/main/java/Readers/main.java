package Readers;

import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lectura leer = new Lectura();
		
		leer.entradaDeDatos();
		
		//String leido = leer.entradaDeDatos();
		
		PrintStream ps = new PrintStream(System.out);
		String texto = "Este va ser el texto <> que yo quiero, manipular.";
		
		ps.println("El char 3:"+ texto.charAt(3));
		ps.println("Sin espacio al principio y/o al final:"+ texto.trim());
		ps.println("en que posicion está"+ texto.indexOf("el")); //
		ps.println("el '>' este ne la pocicion:" + texto.indexOf( '>' ) );
		
		
		}

}
