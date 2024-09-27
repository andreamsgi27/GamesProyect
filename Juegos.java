
import java.util.Random;
import java.util.Scanner;

public class Juegos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugarOtraVez;
        int elegirJuego;


        do {
            try {
                System.out.println("¿A qué quieres jugar? 1 - Ahorcado, 2 - Conecta Cuatro, 3 - Adivina el número, 4 - Salir");
                elegirJuego = scanner.nextInt();
                
                if (elegirJuego == 1) {
                    Ahorcado.jugar(scanner, random);
                } else if (elegirJuego == 2) {
                    Conecta4.main(args);
                } else if (elegirJuego == 3) {
                    Adivina.jugar(scanner, random);
                } else if (elegirJuego == 4) {
                    break;
                } else {
                    System.out.println("Error. Vuelve a elegir una opción válida.");
                }
                
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar la entrada no válida
            }
                
            } while(true);

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
