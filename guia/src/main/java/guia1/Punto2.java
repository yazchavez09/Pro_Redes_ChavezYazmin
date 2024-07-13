package guia1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import java.time.*;

public class Punto2 {
	static PrintStream ps = new PrintStream(System.out);
	static Readers readers = new Readers();

	static ArrayList ejercicioA2() {
		ps.println("Ingrese el primer apellido");
		String Apellido1 = readers.lector();

		ps.println("Ingrese el segundo apellido");
		String Apellido2 = readers.lector();

		ps.println("Ingrese el tercer apellido");
		String Apellido3 = readers.lector();

		ArrayList apellidos = new ArrayList<String>();
		apellidos.add(Apellido1);
		apellidos.add(Apellido2);
		apellidos.add(Apellido3);

		ArrayList apellidosOrd = new ArrayList<String>();
		Collections.sort(apellidos);

		return apellidos;
	}

	static ArrayList ejercicioB2() {
		ps.println("Ingrese el primer numero");
		String dato1 = readers.lector();
		int numero1 = Integer.parseInt(dato1);

		ps.println("Ingrese el segundo numero");
		String dato2 = readers.lector();
		int numero2 = Integer.parseInt(dato2);

		ps.println("Ingrese el tercer numero");
		String dato3 = readers.lector();
		int numero3 = Integer.parseInt(dato3);

		ps.println("Ingrese el cuarto numero");
		String dato4 = readers.lector();
		int numero4 = Integer.parseInt(dato4);

		ArrayList numeros = new ArrayList<String>();
		numeros.add(numero1);
		numeros.add(numero2);
		numeros.add(numero3);
		numeros.add(numero4);
		Collections.sort(numeros);
		ps.print(numeros.get(0));

		return numeros;
	}

	static String ejercicioC2() {
		ps.println("Ingrese un numero");

		String dato = readers.lector();
		int num = Integer.parseInt(dato);
		if (num % 2 == 0) {
			return "El numero es par";
		} else {
			return "El numero es impar";
		}

	}

	static String ejercicioD2() {
		ps.println("Ingrese el primer numero");

		String dato = readers.lector();
		int numero1 = Integer.parseInt(dato);

		ps.println("Ingrese el segundo numero");

		String dato1 = readers.lector();
		int numero2 = Integer.parseInt(dato1);

		if (numero1 > numero2) {
			if (numero1 % numero2 == 0) {
				return (numero1 + " Es divisible por " + numero2);
			}
		} else if (numero2 > numero1) {
			if (numero2 % numero1 == 0) {
				return (numero2 + " Es divisible por " + numero1);
			}
		} else {
			return "Son iguales";
		}
		return "Los números no se pueden dividir entre si";
	}

	static String ejercicioE2() {
		ps.println("Ingrese su fecha de nacimiento");
		ps.println("Ingrese el año de nacimiento ");

		String dato = readers.lector();
		int A = Integer.parseInt(dato);

		ps.println("Ingrese el mes: ");

		String dato1 = readers.lector();
		int M = Integer.parseInt(dato1);

		ps.println("Ingrese el día: ");

		String dato2 = readers.lector();
		int D = Integer.parseInt(dato2);

		LocalDate fecha = LocalDate.of(A, M, D);
		ps.println("Su fecha de nacido es: " + fecha);

		if ((M == 1 && D >= 20) || (M == 2 && D <= 18)) {
			return "Su signo es Acuario";

		} else if ((M == 2 && D >= 19) || (M == 3 && D <= 20)) {
			return "Su signo es Piscis";

		} else if ((M == 3 && D >= 21) || (M == 4 && D <= 19)) {
			return "Su signo es Aries";

		} else if ((M == 4 && D >= 20) || (M == 5 && D <= 20)) {
			return "Su signo es Tauro";

		} else if ((M == 5 && D >= 21) || (M == 6 && D <= 20)) {
			return "Su signo es Géminis";

		} else if ((M == 6 && D >= 21) || (M == 7 && D <= 22)) {
			return "Su signo es Cáncer";

		} else if ((M == 7 && D >= 23) || (M == 8 && D <= 22)) {
			return "Su signo es Leo";

		} else if ((M == 8 && D >= 23) || (M == 9 && D <= 22)) {
			return "Su signo es Virgo";

		} else if ((M == 9 && D >= 23) || (M == 10 && D <= 22)) {
			return "Su signo es LiBra";

		} else if ((M == 10 && D >= 23) || (M == 11 && D <= 21)) {
			return "Su signo es Escorpio";

		} else if ((M == 11 && D >= 22) || (M == 12 && D <= 21)) {
			return "Su signo es Sagitario";

		} else if ((M == 12 && D >= 22) || (M == 1 && D <= 19)) {
			return "Su signo es Capricornio";

		}
		return "La fecha es incorrecta";
	}

	static String ejercicioF2() {
		ps.println("Ingrese el primer apellido: ");
		String apellido1 = readers.lector();

		int longitudApellido1 = apellido1.length();

		ps.println("Ingrese el segundo apellido: ");
		String apellido2 = readers.lector();

		int longitudApellido2 = apellido2.length();

		if (longitudApellido1 > longitudApellido2)
			return apellido1 + " es mas largo que " + apellido2 + " por " + (longitudApellido1 - longitudApellido2)
					+ " letras";
		else if (longitudApellido1 < longitudApellido2) {
			return apellido2 + " es mas largo que " + apellido1 + " por " + (longitudApellido2 - longitudApellido1)
					+ " letras";
		} else
			return apellido1 + apellido2 + "tienen" + apellido2.length() + " letras cada uno";

	}

	static void ejercicioG2() {
		ps.println("Ingrese un numero para hacer su respectiva tabla: ");

		String dato = readers.lector();
		int numero = Integer.parseInt(dato);

		for (int i = 0; i <= 10; i++) {
			ps.println(numero + " x " + i + " = " + (numero * i));
		}
	}

	static void ejercicioH2() {
		ps.println("Ingrese un numero para saber si es primo: ");

		String dato = readers.lector();
		int numero = Integer.parseInt(dato);
		boolean Primo = true;

		if (numero <= 1) {
			Primo = false;
		} else {
			for (int i = 2; i <= Math.sqrt(numero); i++) {
				if (numero % i == 0) {
					Primo = false;
					break;
				}
			}
		}
		if (Primo) {
			ps.println("El número " + numero + " es primo");
		} else {
			ps.println("El número " + numero + " no es primo");
		}
	}

}