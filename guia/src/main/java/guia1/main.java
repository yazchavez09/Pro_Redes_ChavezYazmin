package guia1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;

public class main {

	static PrintStream ps = new PrintStream(System.out);
	static boolean continuar = true;

	public static void main(String[] args) {

		while (continuar) {
			ps.println("Ingrese la opción a ejecutar:");

			ps.println("1- Punto 1");
			ps.println("2- Punto 2");
			ps.println("3- Punto 3");

			ps.println("0- SALIR");

			int opcion = main.leerOpcion();

			switch (opcion) {

			case 1:
				main.WhileP1();
				break;
			case 2:
				main.WhileP2();
				break;
			case 3:
				main.WhileP3();
				break;

			case 0:
				ps.println("Saliendo");
				continuar = false;
				break;
			default:
				ps.println("Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}
		}

	}

	static int leerOpcion() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream pss = new PrintStream(System.out);
		int opcion = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			pss.println("Ingrese la opción:");
			try {
				String input = reader.readLine();
				opcion = Integer.parseInt(input);

				if (opcion >= 0) {
					entradaValida = true;
				} else {
					pss.println("Error: Por favor, ingrese un número entero positivo.");
				}
			} catch (NumberFormatException | IOException e) {
				pss.println("Error: Por favor, ingrese un número entero válido.");
			}
		}

		return opcion;
	}

	static void WhileP1() {

		while (continuar) {
			ps.println("Ingrese la opción deseada del punto 1:");
			ps.println("1-Punto 1 (A)");
			ps.println("2-Punto 1 (B)");
			ps.println("3-Punto 1 (C)");
			ps.println("4-Punto 1 (D)");
			ps.println("5-Punto 1 (E)");
			ps.println("6-Punto 1 (F)");
			ps.println("7-Punto 1 (G)");

			ps.println("0- SALIR");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
				ps.println("Ejecutando Punto 1 (A)");
				ps.println(Punto1.ejercicioA());
				break;
			case 2:
				ps.println("Ejecutando Punto 1 (B)");
				ps.println(Punto1.ejercicioB());
				break;
			case 3:
				ps.println("Ejecutando Punto 1 (C)");
				ps.println(Punto1.ejercicioC());
				break;
			case 4:
				ps.println("Ejecutando Punto 1 (D)");
				ps.println(Punto1.ejercicioD());
				break;
			case 5:
				ps.println("Ejecutando Punto 1 (E)");
				ps.println(Punto1.ejercicioE());
				break;
			case 6:
				ps.println("Ejecutando Punto 1 (F)");
				ps.println(Punto1.ejercicioF());
				break;
			case 7:
				ps.println("Ejecutando Punto 1 (G)");
				ps.println(Punto1.ejercicioG());
				break;
			case 0:
				ps.println("Saliendo");
				continuar = false;
				break;
			default:
				ps.println("ingrese una opción válida.");
				break;

			}
		}
	}

	static void WhileP2() {

		while (continuar) {
			ps.println("Ingrese la opción deseada del punto 2:");
			ps.println("1- Punto 2 (A)");
			ps.println("2- Punto 2 (B)");
			ps.println("3- Punto 2 (C)");
			ps.println("4- Punto 2 (D)");
			ps.println("5- Punto 2 (E)");
			ps.println("6- Punto 2 (F)");
			ps.println("7- Punto 2 (G)");
			ps.println("8- Punto 2 (H)");

			ps.println("0- SALIR");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
				ps.println("Ejecutando Punto 2 (A)");
				ps.println(Punto2.ejercicioA2());
				break;
			case 2:
				ps.println("Ejecutando Punto 2 (B)");
				ps.println(Punto2.ejercicioB2());
				break;
			case 3:
				ps.println("Ejecutando Punto 2 (C)");
				ps.println(Punto2.ejercicioC2());
				break;
			case 4:
				ps.println("Ejecutando Punto 2 (D)");
				ps.println(Punto2.ejercicioD2());
				break;
			case 5:
				ps.println("Ejecutando Punto 2 (E)");
				ps.println(Punto2.ejercicioE2());
				break;
			case 6:
				ps.println("Ejecutando Punto 2 (F)");
				ps.println(Punto2.ejercicioF2());
				break;
			case 7:
				ps.println("Ejecutando Punto 2 (G)");
				Punto2.ejercicioG2();
				break;
			case 8:
				ps.println("Ejecutando Punto 2 (H)");
				Punto2.ejercicioH2();
				break;
			case 0:
				ps.println("Saliendo");
				continuar = false;
				break;
			default:
				ps.println("ingrese una opción válida.");
				break;

			}
		}
	}

	static void WhileP3() {

		while (continuar) {
			ps.println("Ingrese la opción deseada del punto 3:");
			ps.println("1- Punto 3 (A)");
			ps.println("2- Punto 3 (B)");
			ps.println("3- Punto 3 (C)");
			ps.println("4- Punto 3 (D)");
			ps.println("5- Punto 3 (E)");
			ps.println("6- Punto 3 (F)");
			ps.println("7- Punto 3 (G)");

			ps.println("0- SALIR");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
				ps.println("Ejecutando Punto 3 (A)");
				Punto3.ejercicioA3();
				break;
			case 2:
				ps.println("Ejecutando Punto 3 (B)");
				Punto3.ejercicioB3();
				break;
			case 3:
				ps.println("Ejecutando Punto 3 (C)");
				Punto3.ejercicioC3();
				break;
			case 4:
				ps.println("Ejecutando Punto 3 (D)");
				Punto3.ejercicioD3();
				break;
			case 5:
				ps.println("Ejecutando Punto 3 (E)");
				Punto3.ejercicioE3();
				break;
			case 6:
				ps.println("Ejecutando Punto 3 (F)");
				Punto3.ejercicioF3();
				break;
			case 7:
				ps.println("Ejecutando Punto 3 (G)");
				Punto3.ejercicioG3();
				break;
			case 0:
				ps.println("Saliendo");
				continuar = false;
				break;
			default:
				ps.println("ingrese una opción válida.");
				break;

			}
		}
	}
}
