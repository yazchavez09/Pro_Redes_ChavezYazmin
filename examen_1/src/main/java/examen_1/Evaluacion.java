package examen_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Evaluacion {


	static PrintStream ps = new PrintStream(System.out);

	public static File original = new File("datos.dat");
	public static File copia = new File(" tuti_fruti.txt");
	
	public static void mostrarMenu() {
		while (true) {
			ps.println("Menú");
			ps.println();
			ps.println("1. Agregar Datos:");
			ps.println();
			ps.println("2. Eliminar datos:");
			ps.println();
			ps.println("3. Datos tuti");
			ps.println();
			ps.println("4. Salir");
			ps.println();
			ps.print("Elija una opción: ");

			String opcion = entradaDeDatos();

			switch (opcion) {
			case "1":
				ps.println();
				ps.println("1: Agregar");

				break;
			case "2":
				ps.println();
				ps.println("2:");
				ps.println();

				break;

			case "3":
				ps.println();
				ps.println("Datos tuti");
				ps.println();
				mostrarTuti();

				break;

			case "4":
				ps.println();
				ps.println("Saliendo...");
				ps.println();
				return;
			default:
				ps.println("Opción inválida. Intente nuevamente.");

			}
		}
	}

	public static void mostrarTuti() {

		ps.println(Utils.ANSI_CYAN + Utils.ANSI_BLACK_BOLD + "Tutti-Fruti" + Utils.ANSI_RESET);
		ps.println();

		try {

			FileReader fr = new FileReader("datos.dat");

			BufferedReader br = new BufferedReader(fr);

			String linea;

			ps.println(Utils.ANSI_BLUE + "COLOR\t" + "ANIMAL\t" + "COSA\t" + "COMIDA\t" + Utils.ANSI_RESET);

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split("\\.");

				String Letra = datos[0];
				String Animal = datos[1];
				String Color = datos[2];
				String Cosa = datos[3];
				String Comida = datos[4];

				ps.print(Utils.ANSI_GREEN + Animal + "\t" + Utils.ANSI_RESET);
				ps.print(Utils.ANSI_RED + Color + "\t" + Utils.ANSI_RESET);
				ps.print(Utils.ANSI_PURPLE + Cosa + "\t" + Utils.ANSI_RESET);
				ps.print(Utils.ANSI_CYAN + Comida + "\t" + Utils.ANSI_RESET);
				ps.println();

			}
			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static  String entradaDeDatos() {
		String cadena = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			cadena = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}




	public static void editarArchivo() {

		FileReader Fr = null;
		BufferedReader Br = null;
		FileWriter Fw = null;
		PrintWriter Pw = null;

		try {
			Fr = new FileReader(original);
			Br = new BufferedReader(Fr);

			if (!copia.exists()) {

				Fw = new FileWriter(copia);
				Pw = new PrintWriter(Fw);

				String renglon;
				while ((renglon = Br.readLine()) != null) {

					String datos = renglon.substring(1, 2).toUpperCase() + renglon.replace(".", ";");

					Pw.println(datos);
					Pw.flush();
				}
				Pw.close();
				Fw.close();
			}
			Br.close();
			Fr.close();

			if (original.exists())
				original.delete();

		} catch (FileNotFoundException e) {
			Logger.getLogger(Evaluacion.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Evaluacion.class.getName()).log(Level.WARNING, null, e);
		} finally {

		}
	}
	

	static void archivoexiste() {

		if (!original.exists()) {
			mostrarMenu();

		} else if (original.exists()) {
			editarArchivo();
		}
	
}

		

	
	

	
}