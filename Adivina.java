
import java.util.Random;
import java.util.Scanner;

public class Adivina {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(0,100);
        System.out.println("Adivina el número que estoy pensando: ");
        int numIntroducido = scanner.nextInt();
        int conteo = 0;

        while (numIntroducido != randomNum){
            if (numIntroducido > randomNum){
                conteo++;
                System.out.println("El numero es menor, es tu intento nº " + conteo + ". Prueba con otro número.");
            } else {
                conteo++;
                System.out.println("El numero es mayor, es tu intento nº " + conteo + " Prueba con otro número.");
            }
            numIntroducido = scanner.nextInt();
        }
        conteo++;
        System.out.println("Correcto! Lo has conseguido al " + conteo +"º intento.");

        scanner.close();
    }
    
}