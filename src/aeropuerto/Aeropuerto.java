package aeropuerto;

import java.util.Scanner;

public class Aeropuerto {

    public static void main(String[] args) {
        // Declaración de variables
        int vuelos[][] = new int[6][3];
        String destino = "";
        String vuelo = "";

        // Scanner
        Scanner teclado = new Scanner(System.in);

        // Carga de datos
        System.out.println("Carga de datos");
        System.out.println("--------------");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                vuelos[row][col] = 100;
            }
        }

        // Muestro cuadro de vuelos
        System.out.println("                    \tMañana\tMediod\tNoche");
        for (int row = 0; row < 6; row++) {
            destino = switch (row) {
                case 0 ->
                    "Río de Janeiro";
                case 1 ->
                    "Cancún";
                case 2 ->
                    "Madrid";
                case 3 ->
                    "Roma";
                case 4 ->
                    "Milán";
                case 5 ->
                    "Iguazú";
                default ->
                    "";
            };
            // Relleno nombre para que todos ocupen 20 chars
            String destinoTemp = destino;
            for (int i = 1; i <= (20 - destino.length()); i++){
                destinoTemp = destinoTemp + "-";
            }
            destino = destinoTemp;
            System.out.print(destino + "\t");
            for (int col = 0; col < 3; col++) {
                System.out.print(vuelos[row][col] + "\t");
            }
            System.out.println("");
        }

        // Venta de pasajes. Ingresar destino, numero de vuelo y cantidad de pasajes.
        Scanner teclado2 = new Scanner(System.in);
        String usuario = "";
        while (!usuario.equalsIgnoreCase("finish")) {
            System.out.print("Ingrese su nombre: ");
            usuario = teclado2.next();

            System.out.println("Ingrese su destino");
            System.out.println("0- Río de Janeiro");
            System.out.println("1- Canún");
            System.out.println("2- Madrid");
            System.out.println("3- Roma");
            System.out.println("4- Milán");
            System.out.println("5- Iguazú");

            int row = teclado.nextInt();

            System.out.println("Ingrese el horario");
            System.out.println("0- Mañana");
            System.out.println("1- Tarde");
            System.out.println("2- Noche");

            int col = teclado.nextInt();

            System.out.println("Ingrese cantidad de asientos requeridos");

            int cantidad = teclado.nextInt();

            // Compruebo disponibilidad
            if (vuelos[row][col] >= cantidad) {
                //hay
                vuelos[row][col] = vuelos[row][col] - cantidad;
                if (cantidad == 1) {
                    System.out.println("Pasaje vendido");
                } else {
                    System.out.println("Pasajes vendidos");
                }
                //imprimo en pantalla la cantidad de asientos que quedan para ese destino / horario
                System.out.println("Quedan " + vuelos[row][col] + " para ese destino/horario.");

            } else {
                //no hay
                System.out.println("Disculpe, quedan solo " + vuelos[row][col] + " asientos disponibles.");
            }
        }

    }

}
