
import java.util.Scanner;
import java.util.Random;

public class Juegos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugarOtraVez;
        int elegirJuego;


        do {
            System.out.print("¿A qué quieres jugar? 1 - Ahorcado, 2 - Conecta Cuatro, 3 - Adivina el número, 4 - Salir");
            elegirJuego = scanner.nextInt();
            if (elegirJuego == 1) {
                jugarAhorcado(random, scanner);
            } else if (elegirJuego == 2) {
                jugarConecta4(random, scanner);
            } else if (elegirJuego == 3){
                jugarAdivina(random, scanner);
            } else if (elegirJuego == 4){
                break;
            } else{
                System.out.println("Error");
            }
            } while(true);

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    public static void jugarAhorcado(Random random, Scanner scanner){
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
    }
}
