package guia1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Punto3 {
	static PrintStream ps = new PrintStream(System.out);
	static Readers readers = new Readers();

	static void ejercicioA3() {
		File archivo = new File("DATOS.txt");

		ps.println("Ingrese un dato: ");
		String dato = readers.lector();

		ps.println("Ingrese otro dato: ");
		String dato1 = readers.lector();

		FileWriter Fw = null;
		PrintWriter Pw = null;

		try {
			Fw = new FileWriter(archivo, true);
			Pw = new PrintWriter(Fw);
			Pw.println("Ultimo dato ingresado: ");
			Pw.println(dato1);
			Pw.flush();

		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			;
			e.printStackTrace();
		} finally {
			try {
				if (Pw != null)
					Pw.close();
				if (Fw != null)
					Fw.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
				;
			}
		}
	}

	static void ejercicioB3() {
		File archivo = new File("NUMEROS.txt");

		System.out.println("cuantos datos ingresara? ");
		String dato = readers.lector();
		int cant_datos = Integer.parseInt(dato);

		FileWriter Fw = null;
		PrintWriter Pw = null;

		try {
			Fw = new FileWriter(archivo, false);
			Pw = new PrintWriter(Fw);

			for (int i = 0; i < cant_datos; i++) {
				System.out.println("Dato " + (i + 1) + ":");
				String dato2 = readers.lector();

				if (dato2.matches(".*\\d.*")) {
					Pw.println(dato2);
				}
			}

			Pw.flush();

		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			e.printStackTrace();
		} finally {
			try {
				if (Pw != null) {
					Pw.close();
				}
				if (Fw != null) {
					Fw.close();
				}
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}
	}

	static void ejercicioC3() {
		File archivo = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\números.txt");
		FileWriter Fw = null;
		PrintWriter Pw = null;
		try {
			Fw = new FileWriter(archivo, false);
			Pw = new PrintWriter(Fw);
			for (int i = 1; i < 1000; i++) {
				if (i % 2 == 0) {
					Pw.println(i);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (Pw != null) {
					Pw.close();
				}
				if (Fw != null) {
					Fw.close();
				}
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}
	}

	static void ejercicioD3() {
		File archivo = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\números.txt");
		FileReader Fr = null;
		BufferedReader Br = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

			Fr = new FileReader(archivo);
			Br = new BufferedReader(Fr);

			String au;

			ps.println("Los datos del archivo pero en consola: ");
			while ((au = Br.readLine()) != null) {
				ps.println(au);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (Fr != null) {
					Fr.close();
				}
				if (Br != null) {
					Br.close();
				}
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}

	}

	public static void ejercicioE3() {
		File ArchivoOriginal = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\números.txt");
		File ArchivoCopia = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\copia.tmp");
		FileReader Fr = null;
		BufferedReader Br = null;
		FileWriter Fw = null;
		PrintWriter Pw = null;

		try {
			Fr = new FileReader(ArchivoOriginal);
			Br = new BufferedReader(Fr);

			if (!ArchivoCopia.exists()) {
				Fw = new FileWriter(ArchivoCopia);
				Pw = new PrintWriter(Fw);
				String au = "";
				while ((au = Br.readLine()) != null) {
					int num = Integer.parseInt(au);
					if (num % 3 != 0) {
						Pw.println(au);
					}
				}
			}
			if (ArchivoOriginal.exists())
				ArchivoOriginal.delete();
			if (ArchivoCopia.exists())
				ArchivoCopia.renameTo(ArchivoOriginal);
		} catch (FileNotFoundException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Pw != null)
					Pw.close();
				if (Fw != null)
					Fw.close();
				if (Br != null)
					Br.close();
				if (Fr != null)
					Fr.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}
	}

	static void ejercicioF3() {
		File a = new File("D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\números.txt");
		File a2 = new File("D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\primos.dat");

		FileReader Fr = null;
		BufferedReader Br = null;
		FileWriter Fw = null;
		PrintWriter Pw = null;
		try {
			Fr = new FileReader(a);
			Br = new BufferedReader(Fr);
			Fw = new FileWriter(a2);
			Pw = new PrintWriter(Fw);
			String au;

			while ((au = Br.readLine()) != null) {
				int num = Integer.parseInt(au);
				boolean numPrimo = true;

				if (num < 2) {
					numPrimo = false;
				} else {
					for (int i = 2; i <= num / 2; i++) {
						if (num % i == 0) {
							numPrimo = false;
							break;
						}
					}
				}
				if (numPrimo) {
					Pw.println(num);
				}
			}
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Fr != null)
					Fr.close();
				if (Br != null)
					Br.close();
				if (Fw != null)
					Fw.close();
				if (Pw != null)
					Pw.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}

		}
	}

	static void ejercicioG3() {

		File Aoriginal = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\caracteres.dat");
		File Acopia = new File(
				"D:\\Usuario\\Documents\\GitHub\\Pro_Redes_ValdezGabriel\\Guia_1\\Ejercicio3\\copia.tmp");
		FileReader Fr = null;
		BufferedReader Br = null;
		FileWriter Fw = null;
		PrintWriter Pw = null;
		try {
			Fw = new FileWriter(Aoriginal, false);
			Pw = new PrintWriter(Fw);
			for (int i = 0; i <= 10; i++) {
				ps.println("Ingrese una palabra que contenga 'ñ' en la misma: ");
				String dato = Punto1.entradaDeDatos();
				Pw.println(dato);
				Pw.flush();
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Fw != null)
					Fw.close();
				if (Pw != null)
					Pw.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}

		try {
			Fr = new FileReader(Aoriginal);
			Br = new BufferedReader(Fr);
			String au;
			ps.println("Fichero original: ");
			while ((au = Br.readLine()) != null) {
				ps.println(au);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Fr != null)
					Fr.close();
				if (Br != null)
					Br.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}

		try {
			Fw = new FileWriter(Acopia, false);
			Pw = new PrintWriter(Fw);
			Fr = new FileReader(Aoriginal);
			Br = new BufferedReader(Fr);
			String au;
			while ((au = Br.readLine()) != null) {
				String dato = au.replace("ñ", "nie-nio");
				Pw.println(dato);
				Pw.flush();
			}
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Pw != null)
					Pw.close();
				if (Fw != null)
					Fw.close();
				if (Br != null)
					Br.close();
				if (Fr != null)
					Fr.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}
		if (Aoriginal.exists())
			Aoriginal.delete();
		if (Acopia.exists())
			Acopia.renameTo(Aoriginal);

		try {
			Fr = new FileReader(Aoriginal);
			Br = new BufferedReader(Fr);
			String au;
			ps.println("Archivo arreglado: ");
			while ((au = Br.readLine()) != null) {
				ps.println(au);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (Fr != null)
					Fr.close();
				if (Br != null)
					Br.close();
			} catch (IOException e) {
				Logger.getLogger(Punto3.class.getName()).log(Level.WARNING, null, e);
			}
		}
	}

}