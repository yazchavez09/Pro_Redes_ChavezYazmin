package FDD;



import java.io.*;



public class Ejercicio {

    public void ejecutarEjercicios() {

        int[] v1 = new int[5];

        int[] v2 = {6, 3, 0, 3, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintStream ps = new PrintStream(System.out);

        try {

            for (int i = 0; i < 5; i++) {

                ps.println("Ingrese número " + (i + 1) + "° del primer vector");

                try {

					v1[i] = Integer.parseInt(br.readLine());

				} catch (IOException e) {

					e.printStackTrace();
				}

            }

        } 

         catch (NumberFormatException e) {

            ps.println("ingrese un número válido: " + e.getMessage());

        }

        String fileName = "NoVolatil.txt";

        try (FileWriter fileWriter = new FileWriter(fileName)) {

            for (int i = 0; i < v1.length; i++) {

                fileWriter.write(v1[i] + "\n");

            }

            for (int i = 0; i < v2.length; i++) {

                fileWriter.write(v2[i] + "\n");

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        String archivoResultados = "resultados.txt";

        String archivoErrores = "error.txt";


        try (FileWriter resultadosWriter = new FileWriter(archivoResultados);

             FileWriter erroresWriter = new FileWriter(archivoErrores)) {


            for (int i = 0; i < v1.length - 1; i++) {

                int numero1 = v1[i];

                int numero2 = v1[i + 1] - 3;

                try {

                    if (numero2 == 0) {

                        throw new ArithmeticException("Division incorrecta");

                    }

                    double resultado = (double) numero1 / numero2;

                    resultadosWriter.write(numero1 + " / " + numero2 + " = " + resultado + "\n");

                } catch (ArithmeticException e) {

                    erroresWriter.write(numero1 + " / " + numero2 + " = error " + e.getMessage() + "\n");

                }

            }

            for (int i = 0; i < v2.length - 1; i++) {

                int numero1 = v2[i];

                int numero2 = v2[i + 1] - 3;

                try {

                    if (numero2 == 0) {

                        throw new ArithmeticException("Division incorrecta");

                    }

                    double resultado = (double) numero1 / numero2;

                    resultadosWriter.write(numero1 + " / " + numero2 + " = " + resultado + "\n");

                } catch (ArithmeticException e) {

                    erroresWriter.write(numero1 + " / " + numero2 + " = error " + e.getMessage() + "\n");

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}


