package Archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {

    static PrintStream ps = new PrintStream(System.out);

    // Método para mostrar el menú de opciones
    static void mostrarMenu() {
        ps.println("Menú de opciones:");
        ps.println("1. Leer texto y verificar si es un número");
        ps.println("0. Salir");
        ps.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            String opcionStr = Ejercicios.entradaDeDatos();
            if (Ejercicios.verificarNumero(opcionStr) == null) {
                ps.println("Opción inválida. Por favor ingrese un número.");
                continue;
            }

            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    ps.print("Ingrese el texto para verificar: ");
                    String texto = Ejercicios.entradaDeDatos();
                    Object numero = Ejercicios.verificarNumero(texto);
                    if (numero instanceof Integer) {
                        ps.println("El texto ingresado es un número entero: " + numero);
                    } else if (numero instanceof Float) {
                        ps.println("El texto ingresado es un número de punto flotante: " + numero);
                    } else {
                        ps.println("El texto ingresado no es un número.");
                    }
                    break;
                case 0:
                    ps.println("Saliendo...");
                    break;
                default:
                    ps.println("Opción inválida. Por favor intente nuevamente.");
            }
        } while (opcion != 0);
    }
}


//public class main {

	//static PrintStream ps = new PrintStream(System.out);

//static boolean continuar = true;

//public static void main(String[] args) {

//while (continuar) {

		//ps.println("Ingrese la opción a ejecutar:");
			
			//ps.println("1- Ejercicio 1 (a)");

//ps.println("2- Ejercicio 1 (b)");

//ps.println("3- Ejercicio 2");

//ps.println("0- Salir");

//int opcion = main.leerOpcion();

//switch (opcion) {

//case 1:

//ps.println("Ejecutando Ejercicio 1 (a)");

//break;

//case 2:

//ps.println("Ejecutando Ejercicio 1 (b)");


//break;

//		case 3:

//	ps.println("Ejecutando Ejercicio 2");


//	break;

				//	case 0:

//ps.println("Saliendo del menú...");
//
//	continuar = false;

//				break;

//		default:

//			ps.println("Opción inválida. Por favor, ingrese una opción válida.");

//	break;

//	}

//}

//	}

//static int leerOpcion() {

//	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//	int opcion = 0;

//	boolean entradaValida = false;

//	while (!entradaValida) {

//ps.println("Ingrese la opción:");

//try {

//	String input = reader.readLine();

//	opcion = Integer.parseInt(input);

//	if (opcion >= 0) {

//	entradaValida = true;

//} else {

//ps.println("Error: Por favor, ingrese un número entero positivo.");
					
//	}

//} catch (NumberFormatException | IOException e) {

//		ps.println("Error: Por favor, ingrese un número entero válido.");

//}

//}

//return opcion;
		

//	}
//}
