import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese número de filas: ");
        int filas = scanner.nextInt();

        System.out.print("Ingrese número de columnas: ");
        int columnas = scanner.nextInt();

        if (UtilidadesMatriz.validarDimensiones(filas, columnas)) {
            int[][] matriz = UtilidadesMatriz.crearMatriz(filas, columnas);
            System.out.println("Matriz creada con " + filas + " filas y " + columnas + " columnas.");
        } else {
            System.out.println("Dimensiones NO válidas. Intente nuevamente.");
        }

        scanner.close();
    }
}

class UtilidadesMatriz {

    public static boolean validarDimensiones(int filas, int columnas) {
        return filas > 0 && columnas > 0;
    }

    public static int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }
}
