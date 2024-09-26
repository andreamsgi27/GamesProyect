
import java.util.Random;
import java.util.Scanner;

public class Juegos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugarOtraVez;
        int elegirJuego;


        do {
            System.out.println("¿A qué quieres jugar? 1 - Ahorcado, 2 - Conecta Cuatro, 3 - Adivina el número, 4 - Salir");
            elegirJuego = scanner.nextInt();
            if (elegirJuego == 1) {
                Ahorcado.jugar(scanner, random);
            } else if (elegirJuego == 2) {
                Conecta4.main(args);
            } else if (elegirJuego == 3){
                Adivina.jugar(scanner, random);
            } else if (elegirJuego == 4){
                break;
            } else{
                System.out.println("Error");
            }

                
            } while(true);

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
