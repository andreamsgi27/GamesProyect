
import java.util.Scanner;

public class Conecta4 {
    public static void main(String[] args) {
        
        int[][] tablero = new int [6][7];
        String ficha = new String();
        boolean turnoJ1 = true; //para que comience con el jugador 1

        //bucle del juego
        while (true) {
            int columna;
            if (turnoJ1) {
                columna = getColumna(1, tablero); // Turno del jugador 1
            } else {
                columna = getColumna(2, tablero); // Turno del jugador 2
            }
            actualizarTablero(tablero, columna, ficha);
            turnoJ1 = !turnoJ1; // Cambia el turno
        }
    }
        
        

        public static int getColumna (int jugador, int[][] tablero){
            Scanner scanner = new Scanner(System.in);
            int columna = -1;

            while (columna < 1 || columna > 6) {
                System.out.println("Jugador 1, elige la columna donde insertar tu ficha: 1, 2, 3, 4, 5, 6 o 7");
                columna = scanner.nextInt();
    
                if (columna < 0 || columna > 6 || tablero[0][columna] != 0) {
                    System.out.println("Error en la columna. Debes elegir entre la 0 y la 6.");
                }
            }
            scanner.close();
            return columna;
        }
        


        public static void actualizarTablero(int[][] tablero, int columna, String ficha){
            for (int i = 0; i < tablero.length; i++){
                for (int j = 0; j < tablero[i].length; j++){
                    System.out.print("[" + ficha + "]");
                }
        }

        
        /*pedazos de codigo de pruebas:
        String fichaJ1 = "o";
        String fichaJ2 = "x"; //meter estos 2 en una funcion para la ficha

        System.out.println("");
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                System.out.print("[" + ficha + "]");
            }
            System.out.println(""); */
    }
}
