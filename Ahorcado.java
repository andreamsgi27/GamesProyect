import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    
    public static void dibujarAhorcado(int numErrores) {
        String[] dibujoAhorcado = {
                "+---+\n    |\n    |\n    |\n   ===",
                "+---+\n O  |\n    |\n    |\n   ===",
                "+---+\n O  |\n |  |\n    |\n   ===",
                "+---+\n O  |\n/|  |\n    |\n   ===",
                "+---+\n O  |\n/|\\ |\n    |\n   ===",
                "+---+\n O  |\n/|\\ |\n/   |\n   ===",
                "+---+\n O  |\n/|\\ |\n/ \\ |\n   ==="
        };
        System.out.println(dibujoAhorcado[numErrores]);
    }

    public static void jugar(Scanner scanner, Random random) {
        String[] bancoPalabras = {"cambio", "espera", "sufren", "ayudas", "abuela", 
            "estepa", "palcos", "elefante", "murcielago", "naranja", 
            "computadora", "programacion", "java", "desarrollador", 
            "matematica", "astronomia", "filosofia", "ciencia", 
            "geografia", "historia", "arte", "musica", "literatura"};
        int indicePalabraEscogida = random.nextInt(bancoPalabras.length);
        String palabraEscogida = bancoPalabras[indicePalabraEscogida];

        char[] progreso = new char[palabraEscogida.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        int numErrores = 0;  
        int intentosMaximos = 6;  
        boolean palabraAcertada = false;  
        String stringsConFallos = ""; 
        
        while (numErrores < intentosMaximos && !palabraAcertada) {
            System.out.println("Palabra: " + new String(progreso));
            System.out.println("Introduce una letra: ");
            String letraIntroducida = scanner.nextLine();

            if (letraIntroducida.length() != 1 || !Character.isLetter(letraIntroducida.charAt(0))) {
                System.out.println("Por favor, introduce tan sólo una letra.");
                continue;
            }

            char letra = letraIntroducida.charAt(0);
            boolean acierto = false;

            for (int i = 0; i < palabraEscogida.length(); i++) {
                if (palabraEscogida.charAt(i) == letra) {
                    progreso[i] = letra;
                    acierto = true;
                }
            }

            if (acierto) {
                System.out.println("¡Adivinaste una letra!");
                System.out.println("Ya has usado: " + stringsConFallos);
            } else {
                if (!stringsConFallos.contains(String.valueOf(letra))) {
                    stringsConFallos += letra;
                }
                numErrores++;
                System.out.println("La letra " + letra + " es incorrecta.");
                System.out.println("Ya has usado: " + stringsConFallos);
            }

            dibujarAhorcado(numErrores);
            palabraAcertada = new String(progreso).equals(palabraEscogida);
        }

        if (palabraAcertada) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraEscogida);
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + palabraEscogida);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugarOtraVez;

        do {
            jugar(scanner, random);

            System.out.println("¿Quieres jugar de nuevo? (s/n): ");
            jugarOtraVez = scanner.nextLine();

        } while (jugarOtraVez.equals("s"));

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}

