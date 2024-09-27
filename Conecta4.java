import java.util.Scanner;

public class Conecta4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo;

        do {
            int[][] tablero = new int[6][7]; // Por defecto habrá ceros en el tablero (espacios vacíos)
            int jugador1 = 1; // Las fichas del J1 serán un 1
            int jugador2 = 2; // Las fichas del J2 serán un 2
            boolean turnoJ1 = true; // Para que comience con el jugador 1
            boolean juegoTerminado = false; // Para controlar si el juego ha terminado

            // Lógica del juego:
            while (!juegoTerminado) {
                int columna;
                boolean fichaInsertada = false; // Variable para controlar si se inserta ficha

                while (!fichaInsertada) { // Mantener el turno del mismo jugador hasta que se inserte una ficha
                    if (turnoJ1) {
                        System.out.println("Turno del jugador 1:");
                        columna = getColumna(scanner, 1, tablero); // Turno del jugador 1
                        fichaInsertada = actualizarTablero(tablero, columna, jugador1); // Actualiza si se inserta ficha
                        if (fichaInsertada) {
                            imprimirTablero(tablero);
                            if (hayGanador(tablero, jugador1)) {
                                System.out.println("El jugador 1 ha ganado!");
                                juegoTerminado = true; // Termina el juego
                            } else if (tableroLleno(tablero)) {
                                System.out.println("¡Es un empate!");
                                juegoTerminado = true; // Termina el juego
                            }
                            turnoJ1 = false; // Cambia el turno solo si se inserta ficha
                        }
                    } else {
                        System.out.println("Turno del jugador 2:");
                        columna = getColumna(scanner, 2, tablero); // Turno jugador 2
                        fichaInsertada = actualizarTablero(tablero, columna, jugador2); // Actualiza si se inserta ficha
                        if (fichaInsertada) {
                            imprimirTablero(tablero);
                            if (hayGanador(tablero, jugador2)) {
                                System.out.println("El jugador 2 ha ganado!");
                                juegoTerminado = true; // Termina el juego
                            } else if (tableroLleno(tablero)) {
                                System.out.println("¡Es un empate!");
                                juegoTerminado = true; // Termina el juego
                            }
                            turnoJ1 = true; // Cambia el turno solo si se inserta la ficha
                        }
                    }
                } // Fin del bucle del juego

            } // Fin del bucle del juego principal

            // Preguntar si se quiere jugar de nuevo solo al final
            System.out.print("¿Quieres jugar de nuevo? (si/no): ");
            jugarDeNuevo = scanner.next().equalsIgnoreCase("si");
            if (jugarDeNuevo == true) {Juegos.main(args);}

        } while (jugarDeNuevo); // Repetir si el usuario decide jugar de nuevo
        
        scanner.close(); // Cerrar el scanner al final
    }

    public static boolean actualizarTablero(int[][] tablero, int columna, int valorFichaJugador) {
        // Recorre columna para encontrar un espacio vacío
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (tablero[i][columna] == 0) {
                tablero[i][columna] = valorFichaJugador;
                return true; // La ficha fue insertada
            }
        }
        System.out.println("La columna está llena, elige otra.");
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

    // Mostrar el tablero por Consola
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean tableroLleno(int[][] tablero) {
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == 0) { // Si hay algún espacio vacío en la primera fila
                return false; // El tablero no está lleno
            }
        }
        return true; // El tablero está lleno
    }

    public static boolean hayGanador(int[][] tablero, int jugador) {
        // Verifica horizontalmente
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length - 3; j++) {
                if (tablero[i][j] == jugador && tablero[i][j + 1] == jugador && tablero[i][j + 2] == jugador && tablero[i][j + 3] == jugador) {
                    return true;
                }
            }
        }

        // Verifica verticalmente
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j] == jugador && tablero[i + 2][j] == jugador && tablero[i + 3][j] == jugador) {
                    return true;
                }
            }
        }

        // Verifica diagonalmente
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 0; j < tablero[0].length - 3; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j + 1] == jugador && tablero[i + 2][j + 2] == jugador && tablero[i + 3][j + 3] == jugador) {
                    return true;
                }
            }
        }

        // Verifica diagonalmente al revés
        for (int i = 0; i < tablero.length - 3; i++) {
            for (int j = 3; j < tablero[0].length; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j - 1] == jugador && tablero[i + 2][j - 2] == jugador && tablero[i + 3][j - 3] == jugador) {
                    return true;
                }
            }
        }

        return false; // No hay ganador
    }
}

