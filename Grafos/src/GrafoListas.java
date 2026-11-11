import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class GrafoListas {

    ArrayList<Nodos> nodos;

    public GrafoListas(String texto){
        crearListaVertices(texto);
        populateAdyacencias(texto);
    }

    private void crearListaVertices(String origen) {
        String[] lineas = origen.split("\\R");
        nodos = new ArrayList<>();
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

    private void agregarVertice(String nombre) {
        for (Nodos nodo : nodos){
            if(nodo.getNombre().equals(nombre)){
                return;
            }
        }
        nodos.add(new Nodos(nombre));
    }

    private void populateAdyacencias(String origen) {
        String[] lineas = origen.split("\\R");
        String labelPeso = "";
        for (Nodos nodo : nodos){

            int indxV = nodos.indexOf(nodo);
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
                if (extremos.length == 2) {
                    int peso = Integer.parseInt((labelPeso.charAt(labelPeso.indexOf("\"") + 1)) + "");
                    Nodos nodo1 = new Nodos(extremos[0].trim());
                    Nodos nodo2 = new Nodos(extremos[1].trim());
                    if (nodo1 != null && nodo2 != null) {
                        agregarAdyacente(nodo1, nodo2, peso);
                        agregarAdyacente(nodo2, nodo1, peso);
                    }
                }
            }
        }
    }

    private void agregarAdyacente(Nodos nodoOrigen, Nodos nodoDestino, int peso){
        for (Nodos n : nodos){
            if(n.getNombre().equals(nodoOrigen.getNombre())){
                n.agregarAdyacente(nodoDestino, peso);
                return;
            }
        }
    }

    public  void display(){
        for(Nodos n : nodos){
            n.display();
        }
    }

}
