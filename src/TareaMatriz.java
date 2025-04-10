import java.util.Scanner;

public class TareaMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int[][] matriz = null;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            if (validarOpcion(opcion)) {
                switch (opcion) {
                    case 1:
                        matriz = crearMatriz(scanner);
                        break;
                    case 2:
                        mostrarFila(matriz, scanner);
                        break;
                    case 3:
                        verificarMatrizCero(matriz);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Crear matriz");
        System.out.println("2. Mostrar fila");
        System.out.println("3. Verificar matriz tipo cero");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    public static boolean validarOpcion(int opcion) {
        return opcion >= 1 && opcion <= 4;
    }

    public static int[][] crearMatriz(Scanner scanner) {
        System.out.print("Filas: ");
        int filas = scanner.nextInt();
        System.out.print("Columnas: ");
        int columnas = scanner.nextInt();

        if (validarDimensiones(filas, columnas)) {
            int[][] matriz = new int[filas][columnas];
            llenarMatriz(matriz);
            mostrarMatriz(matriz);
            return matriz;
        } else {
            System.out.println("Dimensiones no válidas.");
            return null;
        }
    }

    public static boolean validarDimensiones(int filas, int columnas) {
        return filas > 0 && columnas > 0;
    }

    public static void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarFila(int[][] matriz, Scanner scanner) {
        if (matriz != null) {
            System.out.print("Número de fila: ");
            int fila = scanner.nextInt() - 1;
            if (fila >= 0 && fila < matriz.length) {
                for (int j = 0; j < matriz[fila].length; j++) {
                    System.out.print(matriz[fila][j] + " ");
                }
                System.out.println();
            } else {
                System.out.println("Fila fuera de rango.");
            }
        } else {
            System.out.println("Primero debe crear la matriz.");
        }
    }

    public static void verificarMatrizCero(int[][] matriz) {
        if (matriz != null) {
            int contadorCeros = 0;
            int totalElementos = matriz.length * matriz[0].length;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] == 0) {
                        contadorCeros++;
                    }
                }
            }

            if (contadorCeros > totalElementos / 2) {
                System.out.println("La matriz es tipo cero.");
            } else {
                System.out.println("La matriz no es tipo cero.");
            }
        } else {
            System.out.println("Primero debe crear la matriz.");
        }
    }
}
