package Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.*;

public class Lectura {
//Stream
//Stream IN
//Stream OUT
//Stream ERR
//Stream creado por mi

	PrintStream ps;

	public Lectura() {
		// Intermediario entre la escritura y el canal
		ps = new PrintStream(System.out);

		System.out.println("Byte: ");

		// byte a byte
		System.out.println(13);
		System.out.println(10);
		System.out.println(5);
		System.out.println(27);

		// ASCII UNICODE
		byte[] array = { 78, 64, 119, 97, 19 }; // tienen tope en 255

		try {
			System.out.write(array);
		} catch (IOException e) {
			Logger.getLogger(Readers.Lectura.class.getName()).log(Level.SEVERE, null, e);
			// e.printStackTrace();
		}

		System.err.println("ERROR");

		System.out.flush();

		ps.println("Hola");

		// Print con formato
		ps.printf("El numero elegido es %b %d y su nombre: %s en su cuenta %.2f \n", true, 8, "PEPE", 655.7);

		// Como crear un archivo con linea de codigo
		
		File archivo = new File("error.log"); //archivo de error
		
		//Crea un canal de comunicación de SALIDA con destino: archivo
		FileOutputStream fos = null; 
		
		try {
			fos = new FileOutputStream(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		PrintStream error = new PrintStream(fos, true); //(destino, append)
		
		// Dar otro canal de comunicación
		System.setErr(error);
		// System.setOut(error);
		// System.setIn(null); 

		System.err.println("esto es un error critico");
	}

	public String entradaDeDatos() {

		String cadena = "";
		try {

			// int dato = System.in.read();
			int Byte = -1;
			
			while ((Byte = System.in.read()) != '\n') {
				if (Byte != 13)
					cadena += (char) Byte;
			}
			System.out.print(cadena);
			// System.out.print((char)dato);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return cadena;
	}
}