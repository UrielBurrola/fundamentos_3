class Nodo{
    String nombre;
    int expediente;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String nombre, int expediente){
        this.nombre = nombre;
        this.expediente = expediente;
        this.derecha = null;
        this.izquierda = null;
    }
}

class ArbolBinario{
    private Nodo raiz;
    public ArbolBinario(){
        this.raiz = null;
    }

    public void insertar(String nombre, int expediente){
        raiz = insertarRecursivo(raiz, nombre, expediente);
    }

    private Nodo insertarRecursivo(Nodo nodo, String nombre, int expediente) {
        if (nodo == null){
            return new Nodo(nombre, expediente);
        }
        if(nodo.nombre.compareTo(nombre) >= 0){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, nombre, expediente);
        } else if(nodo.nombre.compareTo(nombre) < 0){
            nodo.derecha = insertarRecursivo(nodo.derecha, nombre, expediente);
        }
        return nodo;
    }

    public void preOrden(){
        preOrddenRecursivo(raiz);
    }

    public void enOrden(){
        enOrdenRecursivo(raiz);

    }

    private void enOrdenRecursivo(Nodo nodo) {
        if (nodo != null){
            enOrdenRecursivo(nodo.izquierda);
            System.out.print(nodo.nombre + ":" + nodo.expediente + " ");
            enOrdenRecursivo(nodo.derecha);
        }
    }

    private void preOrddenRecursivo(Nodo nodo) {
        if (nodo != null){
            System.out.print(nodo.nombre + ":" + nodo.expediente +  " ");
            preOrddenRecursivo(nodo.izquierda);
            preOrddenRecursivo(nodo.derecha);
        }
    }

    public void busquesaPorNombre(String nombre){
        Nodo resultado = busquedaRecursiva(raiz, nombre);
        if (resultado != null){
            System.out.println("nombre encontrado: " + resultado.nombre + ":" + resultado.expediente);
        } else {
            System.out.println("Nombre no encontrado");
        }
    }

    private Nodo busquedaRecursiva(Nodo nodo, String nombre) {
        if (nodo.nombre.equals(nombre)) {
            return nodo;
        } else if (nodo.izquierda != null && nodo.nombre.compareTo(nombre) >= 0) {
            return busquedaRecursiva(nodo.izquierda, nombre);
        } else if (nodo.derecha != null && nodo.nombre.compareTo(nombre) < 0) {
            return busquedaRecursiva(nodo.derecha, nombre);
        }
        return null;
    }
}

public class arbolBinarioNombres {
    static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
//        arbol.insertar("b", 2);
//        arbol.insertar("a", 1);
//        arbol.insertar("d", 4);
//        arbol.insertar("c", 3);
        arbol.insertar("ab", 11);
        arbol.insertar("ac", 12);

        arbol.preOrden();
        System.out.println();
        arbol.enOrden();
        System.out.println();

        arbol.busquesaPorNombre("ab");
        arbol.busquesaPorNombre("e");
    }
}
