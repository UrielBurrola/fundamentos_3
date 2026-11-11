import java.util.ArrayList;

public class Nodos {
    String nombre;
    int peso;
    ArrayList<Nodos> adyacentes;

    public Nodos(String nombre){
        this.nombre = nombre;
        this.peso = 0;
        this.adyacentes = new ArrayList<>();
    }

    public void agregarAdyacente(Nodos nodo, int peso){
        adyacentes.add(nodo);
    }

    public void display(){
        System.out.print(nombre);
        System.out.println("|Adyacentes: ");
        for(Nodos n : adyacentes){
            System.out.println(n.nombre + " : " + peso + " ");
        }
        System.out.println();
    }

    public String getNombre(){
        return nombre;
    }

    public int getPeso(){
        return peso;
    }

    public ArrayList<Nodos> getAdyacentes(){
        return adyacentes;
    }


}
