import java.util.Scanner;

public class Conecta4 {
    public static void main(String[] args) {
        int[][] tablero = new int[6][7];
        int jugador1 = 1;
        int jugador2 = 2;
        boolean turnoJ1 = true; // para que comience con el jugador 1
        Scanner scanner = new Scanner(System.in);

        // Lógica del juego:
        while (true) {
            int columna;
            boolean fichaInsertada = false; // Variable para controlar si se inserta ficha

            while (!fichaInsertada) { // Mantener el turno del mismo jugador hasta que se inserte una ficha
                if (turnoJ1) {
                    System.out.println("Turno del jugador 1:");
                    columna = getColumna(scanner, 1, tablero); // Turno del jugador 1
                    fichaInsertada = actualizarTablero(tablero, columna, jugador1); // Actualiza si se inserta ficha
                    if (fichaInsertada) {
                        imprimirTablero(tablero);
                        turnoJ1 = false; // Cambia el turno solo si se inserta ficha
                    }
                } else {
                    System.out.println("Turno del jugador 2:");
                    columna = getColumna(scanner, 2, tablero); // Turno jugador 2
                    fichaInsertada = actualizarTablero(tablero, columna, jugador2); // Actualiza si se inserta ficha
                    if (fichaInsertada) {
                        imprimirTablero(tablero);
                        turnoJ1 = true; // Cambia el turno solo si se inserta la ficha
                    }
                }
            }
        }
    }

    public static boolean actualizarTablero(int[][] tablero, int columna, int valorFichaJugador) {
        // Verifica desde la última fila hacia arriba para encontrar un espacio vacío
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (tablero[i][columna] == 0) {
                tablero[i][columna] = valorFichaJugador;
                return true; // La ficha fue insertada correctamente
            }
        }
        System.out.println("La columna está llena, elige otra."); // Mensaje cuando la columna está llena
        return false; // La columna estaba llena, no se pudo insertar
    }

    public static int getColumna(Scanner scanner, int jugador, int[][] tablero) {
        int columna = -1;

        // Repite hasta que el jugador elija una columna válida
        while (columna < 0 || columna > 6) {
            System.out.print("Elige la columna donde insertar tu ficha: 0, 1, 2, 3, 4, 5 o 6: ");
            columna = scanner.nextInt();

            // Verifica si la columna está fuera de rango
            if (columna < 0 || columna > 6) {
                System.out.println("Error en la columna. Debes elegir entre la 0 y la 6.");
                columna = -1; // Reinicia la selección
            }
        }
        return columna;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
        }
    }
}