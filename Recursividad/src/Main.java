import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        {/*


        long startTime = System.nanoTime();

        for(int i = 0; i < arr.length; i++){
            long sTime = System.nanoTime();
            System.out.println("Fibonacci de " + arr[i] + ": " + fibonacciIlogico(arr[i]));
            long eTime = System.nanoTime();
            System.out.println("Tiempo de ejecucion del ciclo: " + (eTime - sTime)/1000000.0 +"  ms \n");
        }
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (endTime - startTime)/1000000.0 +"  ms");

        while (true) {
            System.out.print("Ingrese un numero: ");
           int n = sc.nextInt();

            int r = fibonacciIlogico(n);

           System.out.printf("Fibonacci de %d es: %d. ", n, r);
            System.out.println("Calculado en "+ (endTime - startTime)/1000000.0 +"  ms");
       }

         */}
        Scanner sc = new Scanner(System.in);
        int[] arr = {22,21,22,23,24,25,26,27,28,29,30};
        int indice = buscar(arr,30, 0,arr.length -1);

    }

    public static int buscar(int[] lista, int x, int ini, int fin){
        if(ini > fin) return -1;
        int mid = (ini + fin) >>> 1;
        if (lista[mid] == x) return mid;
        if (x < lista[mid]) return buscar(lista, x, ini, mid - 1);
        return buscar(lista, x, mid + 1, fin);
    }

    private static int  calcularfactorial(int numero){
        if(numero == 0){
            return 1;
        }
        else{
            return numero * calcularfactorial(numero-1);
        }
    }

    public static int fibonacciIlogico(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else {
            return fibonacciIlogico(n -1) + fibonacciIlogico(n - 2);
        }
    }

    static Map<Integer, Long> memo = new HashMap<>();

    public static long fib(int n){
        if (n <= 1) return n;
        Long guardado = memo.get(n);
        if (guardado != null) return guardado;
        long resultado = fib(n - 1) + fib(n - 2);
        memo.put(n, resultado);
        return resultado;
    }
}
