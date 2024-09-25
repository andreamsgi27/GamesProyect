public class PruebasConecta4 {
    public static void main(String[] args) {
        int[][] tablero = new int[6][7];
        int jugador1 = 1;
        int jugador2 = 2;

        //jugador 1 mete la ficha en la columna 3
        int columna = 3;
        tablero = actualizarTablero(tablero, columna, jugador1);
        imprimirTablero(tablero);
        
    }

    private static int[][] actualizarTablero(int[][] tablero, int columna, int valorFichaJugador){
        for (int i = 0; i < tablero.length; i++) {
            int casilla = tablero[i][columna];
            if(casilla != 0){
                tablero[i-1][columna] = valorFichaJugador;
                break;
            }
            if(i == tablero.length - 1){
                tablero[i][columna] = valorFichaJugador;
            }
        }
        return tablero;
    }

    private static void imprimirTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
