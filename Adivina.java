import java.util.Random;
import java.util.Scanner;

public class Adivina {
    
    //funcion con la lógica del juego
    public static void jugar(Scanner scanner, Random random) {
        int randomNum = random.nextInt(100); //sentencia para generar número aleatorio de 0 a 100
        System.out.println("Adivina el número que estoy pensando (entre 0 y 100): ");
        int numIntroducido = scanner.nextInt();
        int conteo = 0; //variable para guardar el numero de intentos hasta acertar

        //bucle while para comparar números
        while (numIntroducido != randomNum) {
            conteo++; //suma 1 al contador de intentos
            if (numIntroducido > randomNum) {
                System.out.println("El número es menor, es tu intento nº " + conteo + ". Prueba con otro número.");
            } else { //no haría falta poner condición
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

        //bucle que ejecuta el juego, hace que se pueda volver a jugar
        while (true) {
            jugar(scanner, random); //se pasan scanner y random como parámetros para que la función funcione con ellos
            
            
            System.out.println("¿Quieres jugar de nuevo? (si/no): ");
            jugarOtraVez = scanner.next();
            
            
            if (!jugarOtraVez.equals("si")) {
                break; //si no escribes "si", el bucle terminará y pasará a lo último del código
            }
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
