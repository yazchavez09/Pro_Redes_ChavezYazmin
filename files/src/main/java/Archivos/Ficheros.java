package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {

	private File archivo;
	private PrintStream ps;

	// public Ficheros() {
	// String ruta = ""; // " c:\\User\\ "
	// String nombre = "mario";
	// String extension = ".txt";

	public Ficheros(String rut, String name, String ext) {
		String ruta = rut; // " C:\\User\\ "
		String nombre = name;
		String extension = ext; // .exe

		try {
			System.setErr(new PrintStream(new FileOutputStream(new File("Errores.log")), true));
		} catch (FileNotFoundException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
		}
		archivo = new File(ruta.concat(nombre.concat(extension)));
	}

	public File getArchivo() {
		return this.archivo;
	}

	public void datosArchivos() {
		try {

			ps = new PrintStream(System.out);

			ps.println("Name:" + archivo.getName());
			ps.println("Path:" + archivo.getPath());
			ps.println("PathAbs:" + archivo.getAbsolutePath());
			ps.println("PathCannon:" + archivo.getCanonicalPath());
			ps.println("Contenedor del achivo:" + archivo.getParentFile());
			ps.println("Parent:" + archivo.getParent());
			ps.println("Tamanio:" + archivo.getTotalSpace());
			ps.println("ejecutable?:" + archivo.canExecute());
			ps.println("acceso de lectura:" + archivo.canRead());
			ps.println("acceso de escritura:" + archivo.canWrite());
			ps.println("esta oculto?:" + archivo.isHidden());
			// ps.println("Elimina"+ archivo.delete());
			ps.println("existe?" + archivo.exists());
			ps.println("es archivo?" + archivo.isFile());
			ps.println("es carpeta?" + archivo.isDirectory());
			// "Crea ARCHIVOS:" archivo.
			// "Crea ARCHIVOS:" archivo.

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createFilePrintStream(File a) {

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(a, true);
			ps = new PrintStream(fos); // mode append true = no sobreescribe

			ps.println("holaa mundo");
			ps.println("Chauu mundo");

			ps.flush();

		} catch (FileNotFoundException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
				}

		}

	}

	public void createFilePrinter(File a) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {

			if (!a.exists()) {
				a.createNewFile();
			}

			fw = new FileWriter(a, true);
			pw = new PrintWriter(fw);

			pw.println("Otro MUNDO");

		} catch (FileNotFoundException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (pw != null)
					pw.close();

				if (fw != null)
					fw.close();
			} catch (IOException e) {
				Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
			}
		}
	}

	public void createFileBuffered(File a) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(a, true);
			bw = new BufferedWriter(fw);

			bw.write("Explotemos al MUNDO");
			bw.newLine();
			bw.write("Mejor creemos un nuevo MUNDO");

			bw.flush();
		} catch (IOException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (fw != null)
					fw.close();

				if (bw != null)
					bw.close();

			} catch (IOException e) {
				Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING, null, e);
			}
		}

	}

	public String leerCharChar(File a) {
		// como leo un archivo?

		FileReader fr = null;
		String texto = "";

		try {
			fr = new FileReader(a);

			int letra;

			while ((letra = fr.read()) != -1) // la condicion es -1
			{
				texto += (char) letra;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return texto;

	}

	public String leerConReader(File a) {
		FileReader fr = null;
		BufferedReader br = null;
		String texto = "";
		try {
			fr = new FileReader(a);
			br = new BufferedReader(fr);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				texto += linea.concat("\n");
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return texto;
	}
}