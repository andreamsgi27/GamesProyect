import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    
    
    public static void jugar(Scanner scanner, Random random) {
        String [] bancoPalabras = {"cambio","espera","sufren","ayudas", "abuela","estepa", "palcos"};
        int indicePalabraEscogida = random.nextInt(7);
        String palabraEscogida =bancoPalabras[indicePalabraEscogida];
        System.out.println(indicePalabraEscogida);
        System.out.println(palabraEscogida);
        System.out.println("Introduce una letra: ");
        String letraIntroducida = scanner.nextLine();
        System.out.println(letraIntroducida);

        int conteo = 0;

        
    }
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugarOtraVez;

        
        
        while (true) {
            jugar(scanner, random);  
            
            
            System.out.println("¿Quieres jugar de nuevo? (s/n): ");
            jugarOtraVez = scanner.next();
            
            
            if (!jugarOtraVez.equals("s")) {
                break;
            }
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}


// +---+    +---+    +---+    +---+    +---+    +---+    +---+
// |    O   |    O   |    O   |    O   |    O   |    O   |
// |        |    |   |   /|   |   /|\  |   /|\  |   /|\  |
// |        |        |        |        |   /    |   / \  |
// ===      ===      ===      ===      ===      ===      ===