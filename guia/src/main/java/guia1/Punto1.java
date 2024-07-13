package guia1;

import java.io.IOException;
import java.io.PrintStream;

public class Punto1 {
	static PrintStream ps = new PrintStream(System.out);
	static Readers readers = new Readers();

	static String entradaDeDatos() {

		String cadena = "";
		try {
			int Byte = -1;
			while ((Byte = System.in.read()) != '\n') {
				if (Byte != 13)
					cadena += (char) Byte;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return cadena;
	}

	static String ejercicioA() {
		ps.println("Valor de hora: ");
		String dato = entradaDeDatos();
		int HorasTrabajadas = Integer.parseInt(dato);
		ps.println("Cantidad de horas: ");
		String dato2 = entradaDeDatos();
		int cantidadHoras = Integer.parseInt(dato2);
		int Sueldototal = HorasTrabajadas * cantidadHoras;
		return ("El sueldo es  " + "$" + Sueldototal);
	}

	static String ejercicioB() {

		ps.println("Ingrese el primer 嫕gulo: ");
		String dato = entradaDeDatos();
		int angulo1 = Integer.parseInt(dato);
		ps.println("Ingrese el segundo 嫕gulo: ");
		String dato2 = entradaDeDatos();
		int angulo2 = Integer.parseInt(dato2);
		int angulo3 = 180 - angulo1 - angulo2;

		int totalAngulos = angulo1 + angulo2 + angulo3;

		return ("聲gulo faltante: " + angulo3 + "\n" + "Verificaci鏮: \n" + "聲gulo 1 = " + angulo1 + "\n"
				+ "聲gulo 2 = " + angulo2 + "\n" + "聲gulo 3 = " + angulo3 + "\n" + "Suma total = " + totalAngulos);
	}

	static String ejercicioC() {
		ps.println("ingrese el 嫫ea del cuadrado: ");

		String dato = entradaDeDatos();
		double area = Double.parseDouble(dato);

		double lado = Math.sqrt(area);

		double perimetro = 4 * lado;

		return ("El per璥etro del cuadrado es: " + perimetro + " metros");
	}

	static String ejercicioD() {
		ps.println("ingrese la temperatura en Fahrenheit: ");
		String dato = entradaDeDatos();
		double Fahrenheit = Double.parseDouble(dato);
		double Celsius = (Fahrenheit - 32) * 5 / 9;
		return (Fahrenheit + " los grados Fahrenheit en Celisius equivalentes a " + Celsius + " grados");
	}

	static String ejercicioE() {
		ps.println("Por favor, ingrese el tiempo total en segundos: ");

		String dato = entradaDeDatos();
		double segundos = Double.parseDouble(dato);

		double SPorDia = 86400;
		double SPorHora = 3600;
		double SPorMinuto = 60;

		double cantidadDias = segundos / SPorDia;
		double cantidadHoras = segundos / SPorHora;
		double cantidadMinutos = segundos / SPorMinuto;

		return ("El tiempo de " + segundos + " segundos se descompone en: \n" + "D燰s: " + cantidadDias + "\n"
				+ "Horas: " + cantidadHoras + "\n" + "Minutos: " + cantidadMinutos + "\n");
	}

	static String ejercicioF() {

		ps.println("ingrese el precio del art獳ulo: ");

		String dato = entradaDeDatos();
		double precio = Double.parseDouble(dato);

		double precioPlan1 = precio - (precio * 0.10);
		double precioPlan2 = precio + (precio * 0.10);
		double precioPlan3 = precio + (precio * 0.15);
		double precioPlan4 = precio + (precio * 0.25);

		return ("El precio con el plan 1 es: " + precioPlan1 + "\n" + "El precio con el plan 2 es: " + precioPlan2
				+ "\n" + "El precio con el plan 3 es: " + precioPlan3 + "\n" + "El precio con el plan 4 es: "
				+ precioPlan4);
	}

	static String ejercicioG() {
		ps.println("Ingrese su signo: ");

		String signo = entradaDeDatos();

		if (signo.equals("capricornio")) {
			return "entre el 22 de diciemBre y el 19 de enero";
		} else if (signo.equals("acuario")) {
			return "entre el 20 de enero y el 18 de feBrero";
		} else if (signo.equals("piscis")) {
			return "entre el 19 de feBrero y el 20 de marzo";
		} else if (signo.equals("aries")) {
			return "entre el 21 de marzo y el 19 de aBril";
		} else if (signo.equals("tauro")) {
			return "entre el 20 de aBril y el 20 de mayo";
		} else if (signo.equals("geminis")) {
			return "entre el 21 de mayo y el 20 de junio";
		} else if (signo.equals("cancer")) {
			return "entre el 21 de junio y el 22 de julio";
		} else if (signo.equals("leo")) {
			return "entre el 23 de julio y el 22 de agosto";
		} else if (signo.equals("virgo")) {
			return "Naciste entre el 23 de agosto al 22 de septiemBre";
		} else if (signo.equals("liBra")) {
			return "entre el 23 de septiemBre y el 22 de octuBre";
		} else if (signo.equals("escorpio")) {
			return "entre el 23 de octuBre y el 21 de noviemBre";
		} else if (signo.equals("sagitario")) {
			return "entre el 22 de noviemBre y el 21 de diciemBre";
		} else {
			return "El signo que ingreso no existe";
		}
	}

}