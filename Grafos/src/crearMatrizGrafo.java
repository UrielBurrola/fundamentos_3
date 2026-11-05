import java.util.Stack;

class GrafoArrays {
    private String[] vertices;
    private int numVertices;
    private int[][] matrizAdyacencia;

    public GrafoArrays(String origen) {
        creaTablaVertices(origen);
        matrizAdyacencia = new int[numVertices][numVertices];
        populateMatrizAdyacencia(origen);
    }

    private void creaTablaVertices(String origen) {
        String[] lineas = origen.split("\\R");
        vertices = new String[lineas.length * 2];
        numVertices = 0;
        for (String linea : lineas) {
            String arista = linea.trim();
            if (arista.startsWith("{")) {
                arista = arista.substring(1).trim();
            }
            int etiqueta = arista.indexOf('[');
            if (etiqueta >= 0) {
                arista = arista.substring(0, etiqueta);
            }
            String[] extremos = arista.split("--", 2);
            if (extremos.length == 2) {
                agregarVertice(extremos[0].trim());
                agregarVertice(extremos[1].trim());
            }
        }
    }

    private void agregarVertice(String vertice) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertice)) {
                return;
            }
        }
        vertices[numVertices] = vertice;
        numVertices++;
    }

    private void populateMatrizAdyacencia(String origen){
        String[] lineas = origen.split("\\R");
        String labelPeso = "";
        for (String vertice : vertices){

            int indxV = obtenerIndiceVertice(vertice);
            for (String linea : lineas){
                String arista = linea.trim();
                if (arista.startsWith("{")) {
                    arista = arista.substring(1).trim();
                }
                int etiqueta = arista.indexOf('[');
                if (etiqueta >= 0) {
                    labelPeso = arista.substring(etiqueta);
                    arista = arista.substring(0, etiqueta);
                }
                String[] extremos = arista.split("--", 2);
                if (extremos[0].equals(vertice)) {
                    int peso = Integer.parseInt((labelPeso.charAt(labelPeso.indexOf("\"") + 1)) + "");
                    matrizAdyacencia[indxV][obtenerIndiceVertice(extremos[1])] = peso;
                    matrizAdyacencia[obtenerIndiceVertice(extremos[1])][indxV] = peso;
                }
            }
        }
    }

    public void display() {
        System.out.println("Vértices del grafo:");
        displayVertices();
    }

    private void displayVertices() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices[i]);
        }
    }

    public void displayMatrizAdyacencia(){
        System.out.println("Matriz de adyacencia del Grafo:");
        System.out.print("    ");
        for (int i =0; i<numVertices;i++){
            System.out.print(vertices[i].substring(0,3)+ "  ");
        }
        System.out.println();
        displayVerticePonderado();
    }

    private void displayVerticePonderado(){
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i].substring(0,3)+ "  ");
            for(int j = 0; j < numVertices; j++){
                System.out.print(matrizAdyacencia[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.print("   ");

    }

    private int obtenerIndiceVertice(String vertice) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }
    private void agregarArista(String vertice1, String vertice2, int peso) {
        int indice1 = obtenerIndiceVertice(vertice1);
        int indice2 = obtenerIndiceVertice(vertice2);
        if (indice1 >= 0 && indice2 >= 0) {
            matrizAdyacencia[indice1][indice2] = peso;
            matrizAdyacencia[indice2][indice1] = peso; // Para grafos no dirigidos
        }
    }

    public void DFS(String verticeInicial, String verticeFinal){
        boolean[] visitado = new boolean[numVertices];
        int indxInicial = obtenerIndiceVertice(verticeInicial);
        int indxFinal = obtenerIndiceVertice(verticeFinal);
        if(indxInicial == -1 || indxFinal == -1){
            System.out.println("Uno o ambos vertices no exixten en el grafo.");
            return;
        }
        System.out.println("Recorrido desde " + verticeInicial + " a " + verticeFinal);
        Stack<Integer> stack = new Stack<>();
        stack.push(indxInicial);

        while(!stack.isEmpty()){

            int indxActual = stack.pop();

            if(!visitado[indxActual]){

                visitado[indxActual] = true;
                System.out.println(vertices[indxActual] + " ");

                if (indxActual == indxFinal){

                    System.out.println("\n Alcanzamos el vertice final.");
                    return;

                }
            }
            //Agregar Vecinos del indice actual
            for(int i = 0; i < numVertices; i++){
                if(matrizAdyacencia[indxActual][i] != 0 && !visitado[i]){
                    stack.push(i);
                }
            }
        }
    }
}



public class crearMatrizGrafo {

    public static void main(String[] args) {
        String texto = cargaArchivo("C:\\Users\\uriel\\Documents\\Fundamentos_3\\fundamentos_3\\Grafos\\grafo_salon");
        System.out.println("Contenido del archivo:\n" + texto);
        GrafoArrays grafo = new GrafoArrays(texto);
        grafo.display();
        grafo.displayMatrizAdyacencia();

        grafo.DFS("Arcangel", "Lucia");
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
