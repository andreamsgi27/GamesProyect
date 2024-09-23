import java.util.Random;
import java.util.Scanner;

public class Adivina {
    
    
    public static void jugar(Scanner scanner, Random random) {
        int randomNum = random.nextInt(100);
        System.out.println("Adivina el número que estoy pensando (entre 0 y 100): ");
        int numIntroducido = scanner.nextInt();
        int conteo = 0;

        while (numIntroducido != randomNum) {
            conteo++;
            if (numIntroducido > randomNum) {
                System.out.println("El número es menor, es tu intento nº " + conteo + ". Prueba con otro número.");
            } else {
                System.out.println("El número es mayor, es tu intento nº " + conteo + ". Prueba con otro número.");
            }
            numIntroducido = scanner.nextInt();
        }
        
        conteo++;
        System.out.println("¡Correcto! Lo has acertado en el intento nº " + conteo + ".");
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
