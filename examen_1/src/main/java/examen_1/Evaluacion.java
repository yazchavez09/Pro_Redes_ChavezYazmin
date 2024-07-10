package examen_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Evaluacion {

	static PrintStream ps = new PrintStream(System.out);

	public static File original = new File("datos.dat");
	public static File copia = new File(" tuti_fruti.txt");

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

	public static void mostrarmenu() {
		ps.print("menuu");
	}

	static void archivoexiste() {

		if (!original.exists()) {
			mostrarmenu();

		} else if (original.exists()) {
			editarArchivo();
		}

	}
}
