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
		ps.println("ultima aparicion de la letra "+ texto.lastIndexOf('e'));
		ps.println("largo del texto"+ texto.length());
		
		ps.println(""+ texto.equals("hola"));
		ps.println(""+ texto.compareTo("hola"));
		ps.println(""+ texto.compareToIgnoreCase("hola"));
		
		ps.println(""+ texto.contains("que"));
		ps.println("cambia la a por un 4"+ texto.replace("a","4"));
		ps.println(""+ texto.replaceAll(" ","-"));
		
		ps.println(""+ texto.concat("otro texto").concat("otro más"));
		ps.println("todo minusculas"+ texto.toLowerCase());
		ps.println("todo mayus"+ texto.toUpperCase());
		
		ps.println("el texto empieza por Este? "+ texto.startsWith("Este"));
		ps.println("el texto termina en .?"+ texto.endsWith("."));
		
		ps.println("agarra el texto apartir de la pocicion 10"+ texto.substring(10));
		ps.println("agarra el texto apartir de la pocicion 10, 9 caracteres"+ texto.substring(10,9));
		
		ps.println("codePoint: (E)"+ texto.codePointAt(4));
		
		char [] letraAlertra = texto.toCharArray();
		String separar = "esto, es un texto, que vamos, a  separar.";
		String [] vec = separar.split(",");
		separar.split("\\+");
		texto.split("<>");
		
		
	}

}
