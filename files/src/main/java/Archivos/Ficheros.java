package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Ficheros {

	private File archivo;
	private PrintStream ps;

	public Ficheros() {
		String ruta = ""; // " c:\\User\\ "
		String nombre = "mario";
		String extension = ".txt";
		
	//System.setErr(new PrintStre (COMPLETAR)
		
		archivo = new File(ruta.concat(nombre.concat(extension)));
	}

	public File getArchivo() {
		return this.archivo;
	}

	public void createFilePrintStream(File a) {

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(a);
			ps = new PrintStream(fos, true); // mode append true = no sobreescribe

			ps.println("holaa mundo");
			ps.println("Chauu mundo");

			ps.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}

		}

	}

	public void createFilePrinter(File a) {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {

			if (a.exists()) {
				a.createNewFile();
			}

			fw = new FileWriter(a, true);
			pw = new PrintWriter(fw);

			pw.println("Otro MUNDO");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();

				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void createFileBuffer(File a) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter (a, true);
		    bw = new BufferedWriter (fw);
		    
		    bw.write("Explotemos al MUNDO");
		    bw.newLine();
		    bw.write("Mejor creemos un mundo nuevo");
		    bw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}//finally {
			//try {
				//if(pw!=null)
			//}
			
		//}
		
	}
	}

