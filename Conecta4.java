public class Conecta4 {
    public static void main(String[] args) {
        int[][] tablero = new int [6][7];
        String ficha = "o";
        System.out.println("");


        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                System.out.print("[" + ficha + "]");
            }
            System.out.println("");
        }
    }
}
