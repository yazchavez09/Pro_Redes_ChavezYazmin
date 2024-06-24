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
	private File archivo;

	// Menú infinito con las opciones :  Agregar producto, Mostrar , Salir
	public void mostrarMenu() {
		while (true) {
			ps.println(Utils.ANSI_CYAN + Utils.ANSI_BOLD + Utils.ANSI_UNDERLINE +"Menú" + Utils.ANSI_RESET);
			ps.println();
			ps.println(Utils.ANSI_GREEN_BRIGHT + "1. Agregar producto:" + Utils.ANSI_RESET);
			ps.println();
			ps.println(Utils.ANSI_PURPLE + "2. Mostrar productos" + Utils.ANSI_RESET);
			ps.println();
			ps.println(Utils.ANSI_RED_BRIGHT + "3. Salir" + Utils.ANSI_RESET);
			ps.println();
			ps.print(Utils.ANSI_YELLOW + "Elija una opción: " + Utils.ANSI_RESET);

			String opcion = entradaDeDatos();

			switch (opcion) {
			case "1":
				ps.println();
				ps.println(Utils.ANSI_GREEN + "1: Agregar producto" + Utils.ANSI_RESET);

				agregarProducto();
				break;
			case "2":
				ps.println();
				ps.println(Utils.ANSI_PURPLE + "2: Mostrar productos" + Utils.ANSI_RESET);
				ps.println();
				mostrarProductos();
				break;

			case "3":
				ps.println();
				ps.println(Utils.ANSI_RED + "Usted salió exitosamente" + Utils.ANSI_RESET);
				return;
			default:
				ps.println(Utils.ANSI_RED + "Opción inválida. Intente nuevamente." + Utils.ANSI_RESET);
			}
		}
	}

	// Método que permita leer texto de la consola y devolverlo como String
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

	// Métodoque identifique si un texto es o no un numero ( devuelva si no es numero, si es un entero o si es un numero con coma)
	public String verificarTipoDato() {
		ps.println("Escriba el dato:");
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

	// Método que permitan convertir texto (que sean valores numéricos) a números (devolviendo un Int o un Float)
	public boolean esEntero(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			int carac = (int) texto.charAt(i);
			if (carac < 48 || carac > 57) {
				return false;
			}
		}
		return true;
	}

	
	public boolean esNumero(String texto) {
		boolean puntoDecimal = false;

		for (int i = 0; i < texto.length(); i++) {
			int caracter = (int) texto.charAt(i);

			if (caracter == 46 && !puntoDecimal) {
				puntoDecimal = true;
			} else if (caracter < 48 || caracter > 57) {
				return false;
			}
		}
		return true;
	}

	// Pedirle al usuario que ingrese: Nombre de producto, Precio de Compra, Precio de Venta y Stock.
	public void agregarProducto() {
		ps.println();
		ps.print(Utils.ANSI_BLUE_BRIGHT + "Ingrese el nombre del producto: " + Utils.ANSI_RESET);
		String nombreProducto = entradaDeDatos();

			
		ps.print(Utils.ANSI_BLUE_BRIGHT + "Ingrese el precio de compra: " + Utils.ANSI_RESET);
		String precioCompraStr = entradaDeDatos();
		if (!esNumero(precioCompraStr)) {
			ps.println(Utils.ANSI_RED_BRIGHT + "Error: el precio de compra no es válido." + Utils.ANSI_RESET);
			return;
		}
		float precioCompra = Float.parseFloat(precioCompraStr);

		ps.print(Utils.ANSI_BLUE_BRIGHT + "Ingrese el precio de venta: " + Utils.ANSI_RESET);
		String precioVentaStr = entradaDeDatos();
		if (!esNumero(precioVentaStr)) {
			ps.println(Utils.ANSI_RED_BRIGHT + "Error: el precio de venta no es válido." + Utils.ANSI_RESET);
			return;
		}
		float precioVenta = Float.parseFloat(precioVentaStr);

		ps.print(Utils.ANSI_BLUE_BRIGHT + "Ingrese el stock: " + Utils.ANSI_RESET);
		String stockStr = entradaDeDatos();
		if (!esEntero(stockStr)) {
			ps.println(Utils.ANSI_RED_BRIGHT + "Error: el stock no es válido." + Utils.ANSI_RESET);
			return;
		}
		int stock = Integer.parseInt(stockStr);

		guardarProducto(nombreProducto, precioCompra, precioVenta, stock);

		ps.println();
		ps.println(Utils.ANSI_GREEN_BRIGHT + "Producto agregado correctamente." + Utils.ANSI_RESET);
		ps.println();
	}

	

	// Armar método que cree archivo ( Inventario.dat )
		public void crearArchivo() {
		    archivo = new File("inventario.dat");
		    if (!archivo.exists()) {
		        try {
		            archivo.createNewFile();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}

	// Métodos que permitan Agregar los datos pedidos al usuario a un archivo de texto plano: los datos van separados por  ( ; ).
	public void guardarProducto(String nombre, float precioCompra, float precioVenta, int stock) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.dat", true));
			bw.write(nombre + ";" + precioCompra + ";" + precioVenta + ";" + stock + "\n");
		
			 bw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Método que leea de archivos de texto plano
	// Método para mostrar los productos almacenados en el archivo de inventario
	public void mostrarProductos() {

		ps.println(Utils.ANSI_CYAN + Utils.ANSI_BOLD + Utils.ANSI_UNDERLINE + "Lista de Productos" + Utils.ANSI_RESET);
		ps.println();

		try {

			FileReader fr = new FileReader("inventario.dat");

			BufferedReader br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");
				if (datos.length == 4) {
					String nombre = datos[0];
					float precioCompra = Float.parseFloat(datos[1]);
					float precioVenta = Float.parseFloat(datos[2]);
					int stock = Integer.parseInt(datos[3]);
					
					ps.println(Utils.ANSI_BLUE_BRIGHT + "Nombre del producto: " + Utils.ANSI_RESET + nombre);
					ps.println(Utils.ANSI_BLUE_BRIGHT + "Precio de compra: " + Utils.ANSI_RESET + precioCompra);
					ps.println(Utils.ANSI_BLUE_BRIGHT + "Precio de venta: " + Utils.ANSI_RESET + precioVenta);
					ps.println(Utils.ANSI_BLUE_BRIGHT + "Stock: " + Utils.ANSI_RESET + stock);
					ps.println();
				}
			}

			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

