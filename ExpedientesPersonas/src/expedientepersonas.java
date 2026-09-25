//Author: Uri Burrola

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Personas{
    private String nombre;
    private int expediente;
    private int edad;

    public Personas(String nombre, int expediente, int edad) {
        this.nombre = nombre;
        this.expediente = expediente;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getExpediente() {
        return expediente;
    }

    public int getEdad() {
        return edad;
    }
}

public class expedientepersonas {
    static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "C:\\Users\\uriel\\Documents\\Fundamentos_3\\fundamentos_3\\ExpedientesPersonas\\listado_personas_expediente.csv";
        ArrayList<Personas> Personas = cargarPersonas(cadena);
        System.out.println("Listado de personas:");
    }

    public static ArrayList<Personas> cargarPersonas(String nombreArchivo) {
        ArrayList<Personas> personas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes =  linea.split(",");
                if (partes.length == 3){
                    String nombre = partes[0].trim();
                    int expediente = Integer.parseInt(partes[1].trim());
                    int edad = Integer.parseInt(partes[2].trim());

                    personas.add(new Personas(nombre, expediente, edad));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return personas;
    }

    public static HashMap<Integer,Personas> arrayToHashMap(ArrayList<Personas> personas) {
        HashMap<Integer,Personas> hashMap = new HashMap<>();
        for (Personas persona : personas) {
            hashMap.put(persona.getNombre().hashCode(), persona);
        }
        return hashMap;
    }
}
