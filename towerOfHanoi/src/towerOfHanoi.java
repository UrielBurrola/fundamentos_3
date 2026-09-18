// Author: Uriel Burrola
//Date: hoy
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class towerOfHanoi {

    private static Scanner sc = new Scanner(System.in);
    private static int numeroDiscos = 3;

    private static Stack<Integer>[] torres = new Stack[3];

    static void main() {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcion;

        do{
            System.out.printf("""
                ~~ Torres de Hanoi ~~
                    1) Elegir Discos (3 - 9)
                    2) Jugar Manualmente [Num. Discos: %d]
                    3) Mostrar Solucion
                    4) Salir
                """,numeroDiscos);
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> { elegirNumeroDiscos();}
                case 2 -> { jugarManual();}
                case 3 -> {mostrarSolucion();}
                case 4 -> { System.out.println("Hasta luego..."); }
            }
        } while (opcion != 4);
    }

    private static void inicializarTorres(){
        for (int i = 0; i < torres.length; i++){
            torres[i] = new Stack<>();
        }
        for (int i = numeroDiscos; i >= 1; i--){
            torres[0].push(i);
        }
    }

    private static void despliegaTorres(){
        for (int i = 0; i < torres.length; i++){
            despliegaTorre(i);
        }
    }

    private static void despliegaTorre(int torre){
        Object torresAux = torres[torre].clone();
        System.out.print("Torre " + (char)('A' + torre) + ": ");
        for (int disco : torres[torre]){
            System.out.print(disco + " ");
        }
        System.out.println();
    }

    private static void jugarManual() {
        inicializarTorres();

        do {
            despliegaTorres();
            System.out.println("Ingresa la torre a jugar: ");
            String mensaje = sc.nextLine();
            eligeTorre(mensaje);

        } while(true);
    }

    private static String eligeTorre(String mensaje){
        String torre = "";
        do{
            System.out.println(mensaje);
            torre = sc.next().toUpperCase();
            if (!torre.equals("A") && !torre.equals("B") && !torre.equals("C") ) {
                System.out.println("Torre incorrecta");
            }
        }while(!torre.equals("A") && !torre.equals("B") && !torre.equals("C"));
        return torre;
    }

    private static void mostrarSolucion() {
    }

    private static void elegirNumeroDiscos() {
        int sel = 0;
        do {
            System.out.println("Introduce el numero de discos (3 - 9): ");
            sel = leerEntero();
            if(sel < 3 || sel > 9) {
                System.out.println("Numero de discos invalido");
            } else {
                numeroDiscos = sel;
            }
        } while (sel < 3 || sel > 9);
    }

    private static int leerEntero() {
        while(!sc.hasNextInt()) {
            System.out.println("Ingresa un numero valido");
            sc.next();
        }
        return sc.nextInt();
    }
}