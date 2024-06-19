package Archivos;

import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		//PrintStream ps = new PrintStream(System.out);
		Ficheros archivo = new Ficheros(" ","Mario",".txt");
		//archivo.createFilePrintStream(archivo.getArchivo());
		//archivo.createFilePrinter(archivo.getArchivo());
		//archivo.datosArchivos();
		//ps.println (archivo.leerCharChar(archivo.getArchivo()));
		//ps.println (Utils.ANSI_BLUE + archivo.leerConReader(archivo.getArchivo()) + Utils.ANSI_RESET);
		
		archivo.editarArchivo(archivo.getArchivo());
	}

}
