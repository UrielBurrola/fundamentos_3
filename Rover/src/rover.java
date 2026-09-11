import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class rover {
    public static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "C:\\Users\\uriel\\Documents\\Fundamentos_3\\fundamentos_3\\Rover\\path1";
        ArrayList<String> lineas = leerArchivo(cadena);

        Queue<String> queue = addToQueue(lineas);

        travelQueue(queue);

        queue = addToQueue(lineas);

        Deque<String> stack = queueToStack(queue);

        Queue<String> queueInvertido = stackToQueue(stack);

        travelQueue(queueInvertido);
    }

    public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }

    public static Queue<String> addToQueue(ArrayList<String> lineas) {
        Queue<String> queue = new ArrayDeque<>();
        for (String linea : lineas) {
            queue.add(linea);
        }
        return queue;
    }

    public static void travelQueue(Queue<String> queue) {
        while (!queue.isEmpty()) {
            String linea = queue.poll();
            if(linea != null) {
                if(linea.toUpperCase().equals("A")) {
                    System.out.print("^");
                } else if(linea.toUpperCase().equals("D")) {
                    System.out.print("V");
                } else if(linea.toUpperCase().equals("S")) {
                    System.out.print("-");
                }
            }
        }
        System.out.println();
    }

    public static Deque<String> queueToStack(Queue<String> queue) {
        Deque<String> stack = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            String linea = queue.poll();
            if(linea != null) {
               stack.push(linea);
            }
        }
        return stack;
    }

    public static Queue<String> stackToQueue(Deque<String> stack) {
        Queue<String> queue = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            String linea = stack.pop();
            if(linea != null) {
                queue.add(linea);
            }
        }

        return queue;
    }
}
