public class Grafos {

    public static void main(String[] args) {
        String texto = cargaArchivo("C:\\Users\\uriel\\Documents\\Fundamentos_3\\fundamentos_3\\Grafos\\grafo_salon");

        System.out.println("Contenido del archivo:\n" + texto);
        GrafosArray grafoA = new GrafosArray(texto);
        GrafoListas grafoL = new GrafoListas(texto);
        grafoA.display();
        grafoA.displayMatrizAdyacencia();

        grafoA.DFS("Luna", "Sergio");
        grafoA.BFS("Luna", "Sergio");

        System.out.println("Metodo despliegaArcos");
        grafoA.despliegaArcos();

        String caminoDijjstra = grafoA.caminoMasCorto("Luna", "Sergio");
        System.out.println(caminoDijjstra);

        System.out.println("\n--- grafosListas ---\n");
        grafoL.display();
    }

    public static String cargaArchivo(String ruta) {
        String contenido = "";
        try {
            java.io.File archivo = new java.io.File(ruta);
            java.util.Scanner scanner = new java.util.Scanner(archivo);
            while (scanner.hasNextLine()) {
                contenido += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        }
        return contenido;
    }

}
