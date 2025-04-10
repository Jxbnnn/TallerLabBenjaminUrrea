import java.util.Scanner;

public class TareaMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        int[][] matriz = null; // Variable para almacenar la matriz

        Menu menu = new Menu();
        ValidarOpcion validarOpcion = new ValidarOpcion();
        CrearMatriz crearMatriz = new CrearMatriz();
        MostrarMatriz mostrarMatriz = new MostrarMatriz();
        LlenarMatriz llenarMatriz = new LlenarMatriz();
        MostrarFila mostrarFila = new MostrarFila();
        VerificarMatrizCero verificarMatrizCero = new VerificarMatrizCero();

        while (continuar) {
            menu.mostrarMenu();
            int opcion = scanner.nextInt();

            if (validarOpcion.validarOpcion(opcion)) {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese número de filas: ");
                        int filas = scanner.nextInt();
                        System.out.print("Ingrese número de columnas: ");
                        int columnas = scanner.nextInt();

                        if (filas > 0 && columnas > 0) {
                            matriz = crearMatriz.crearMatriz(filas, columnas);
                            System.out.println("Matriz creada con " + filas + " filas y " + columnas + " columnas.");
                            llenarMatriz.llenarMatriz(matriz);
                            mostrarMatriz.mostrarMatriz(matriz);
                        } else {
                            System.out.println("Dimensiones NO válidas. Intente nuevamente.");
                        }
                        break;

                    case 2:
                        if (matriz != null) {
                            System.out.print("Ingrese número de fila para mostrar: ");
                            int fila = scanner.nextInt() - 1;
                            mostrarFila.mostrarFila(matriz, fila);
                        } else {
                            System.out.println("Primero debe crear la matriz.");
                        }
                        break;

                    case 3:
                        if (matriz != null) {
                            if (verificarMatrizCero.matrizCero(matriz)) {
                                System.out.println("La matriz es de tipo cero.");
                            } else {
                                System.out.println("La matriz no es de tipo cero.");
                            }
                        } else {
                            System.out.println("Primero debe crear la matriz.");
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del programa.");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}

class Menu {
    public void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Crear matriz");
        System.out.println("2. Mostrar fila de la matriz");
        System.out.println("3. Verificar si la matriz es tipo cero");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }
}

class ValidarOpcion {
    public boolean validarOpcion(int opcion) {
        return opcion >= 1 && opcion <= 4;
    }
}

class CrearMatriz {
    public int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }
}

class LlenarMatriz {
    public void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }
}

class MostrarMatriz {
    public void mostrarMatriz(int[][] matriz) {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MostrarFila {
    public void mostrarFila(int[][] matriz, int fila) {
        if (fila >= 0 && fila < matriz.length) {
            System.out.print("Contenido de la fila " + (fila + 1) + ": ");
            for (int j = 0; j < matriz[fila].length; j++) {
                System.out.print(matriz[fila][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Número de fila fuera de rango.");
        }
    }
}

class VerificarMatrizCero {
    public boolean matrizCero(int[][] matriz) {
        int contadorCeros = 0;
        int totalElementos = matriz.length * matriz[0].length;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    contadorCeros++;
                }
            }
        }

        return (contadorCeros > totalElementos / 2);
    }
}


