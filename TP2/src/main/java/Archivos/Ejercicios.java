package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ejercicios {

	private static PrintStream ps = System.out;

	// Método para mostrar el menú.
	public void mostrarMenu() {
		while (true) {
			ps.println(Utils.ANSI_CYAN + "Menú" + Utils.ANSI_RESET);
			ps.println(Utils.ANSI_GREEN + "1. Agregar producto" + Utils.ANSI_RESET);
			ps.println(Utils.ANSI_GREEN + "2. Mostrar productos" + Utils.ANSI_RESET);
			ps.println(Utils.ANSI_GREEN + "3. Probar identificación de números" + Utils.ANSI_RESET);
			ps.println(Utils.ANSI_RED + "4. Salir" + Utils.ANSI_RESET);
			ps.print(Utils.ANSI_YELLOW + "Seleccione una opción: " + Utils.ANSI_RESET);

			String opcion = entradaDeDatos();

			switch (opcion) {
			case "1":
				ps.println("1: Agregar producto");
				agregarProducto();
				break;
			case "2":
				ps.println("2: Mostrar productos");
				mostrarProductos();
				break;
			case "3":
				ps.println("3: Probar identificación de números");
				ps.println(verificarTipoDato());
				break;
			case "4":
				ps.println("Saliendo...");
				return;
			default:
				ps.println(Utils.ANSI_RED + "Opción inválida. Intente nuevamente." + Utils.ANSI_RESET);
			}
		}
	}

	// Método para leer entrada de datos desde la consola.
	public String entradaDeDatos() {
		String cadena = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			cadena = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}

	// Método para identificar si un texto es un número y devolverlo como int o
	// float.
	public String verificarTipoDato() {
		ps.println("Escriba :");
		String dato = entradaDeDatos();

		try {
			Integer.parseInt(dato);
			return Utils.ANSI_GREEN + "Número entero" + Utils.ANSI_RESET;
		} catch (NumberFormatException excepcion1) {
			try {
				Float.parseFloat(dato);
				return Utils.ANSI_GREEN + "Número con coma" + Utils.ANSI_RESET;
			} catch (NumberFormatException excepcion2) {
				return Utils.ANSI_RED + "String" + Utils.ANSI_RESET;
			}
		}
	}

	// Método para verificar si un texto es un número entero.
	private boolean esEntero(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			int asciiValue = (int) texto.charAt(i);
			if (asciiValue < 48 || asciiValue > 57) {
				return false;
			}
		}
		return true;
	}

	// Método para verificar si un texto es un número (entero o flotante).
	private boolean esNumero(String texto) {
		boolean puntoDecimal = false;

		for (int i = 0; i < texto.length(); i++) {
			int asciiValue = (int) texto.charAt(i);

			if (asciiValue == 46 && !puntoDecimal) {
				puntoDecimal = true;
			} else if (asciiValue < 48 || asciiValue > 57) {
				return false;
			}
		}
		return true;
	}

	// Método para agregar un producto solicitando los datos al usuario.
	public void agregarProducto() {

		ps.println("Ingrese el nombre del producto:");
		String nombreProducto = entradaDeDatos();

		ps.println("Ingrese el precio de compra:");
		String precioCompraStr = entradaDeDatos();
		if (!esNumero(precioCompraStr)) {
			ps.println(Utils.ANSI_RED + "Error: el precio de compra no es válido." + Utils.ANSI_RESET);
			return;
		}
		float precioCompra = Float.parseFloat(precioCompraStr);

		ps.println("Ingrese el precio de venta:");
		String precioVentaStr = entradaDeDatos();
		if (!esNumero(precioVentaStr)) {
			ps.println(Utils.ANSI_RED + "Error: el precio de venta no es válido." + Utils.ANSI_RESET);
			return;
		}
		float precioVenta = Float.parseFloat(precioVentaStr);

		ps.println("Ingrese el stock:");
		String stockStr = entradaDeDatos();
		if (!esEntero(stockStr)) {
			ps.println(Utils.ANSI_RED + "Error: el stock no es válido." + Utils.ANSI_RESET);
			return;
		}
		int stock = Integer.parseInt(stockStr);

		guardarProducto(nombreProducto, precioCompra, precioVenta, stock);

		ps.println(Utils.ANSI_GREEN + "Producto agregado correctamente:" + Utils.ANSI_RESET);

	}

	// ------------------------------------------------------------------------------------------------

	// Armar métodos que creen archivos ( Inventario.dat )

	public void crearArchivo() {
		File archivo = new File("inventario.dat");
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Método para guardar un producto en el archivo de inventario
	public void guardarProducto(String nombre, float precioCompra, float precioVenta, int stock) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.dat", true));
			bw.write(nombre + ";" + precioCompra + ";" + precioVenta + ";" + stock + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para mostrar los productos almacenados en el archivo de inventario
	public void mostrarProductos() {

		ps.println(Utils.ANSI_CYAN + "Lista de Productos" + Utils.ANSI_RESET);

		try {

			FileReader fr = new FileReader("inventario.dat"); // no me deja poner true

			BufferedReader br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");
				if (datos.length == 4) {
					String nombre = datos[0];
					float precioCompra = Float.parseFloat(datos[1]);
					float precioVenta = Float.parseFloat(datos[2]);
					int stock = Integer.parseInt(datos[3]);

					ps.println("Nombre del producto: " + nombre);
					ps.println("Precio de compra: " + precioCompra);
					ps.println("Precio de venta: " + precioVenta);
					ps.println("Stock: " + stock);
				}
			}

			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

