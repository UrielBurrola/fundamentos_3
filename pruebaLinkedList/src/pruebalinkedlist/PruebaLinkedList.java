/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebalinkedlist;

class Student{
    String name;
    int score;
    Student next;
    
    public Student(String name, int score){
        this.name = name;
        this.score = score;
        this.next = null;
    }
}

class LnkdList {
    
    Student head;
    
    public LnkdList(){
        this.head = null;
    }
    
    public void add(String name, int score){
        Student newStudent = new Student(name,score);
        if (head == null){
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newStudent;
        }
    }
    //This is a prueba
    
    public void print(){
        Student current = this.head;
        while(current !=null) {
            System.out.println(current.name + " - " + current.score);
            current = current.next;
        } 
    }
    
    public Student retrieve(String searched){
        Student current = this.head;
        while(current != null){
            if (current.name.equals(searched)){
                return current;
            } 
            current = current.next; 
        }
        return null;
    }
    
    public void remove(int n){
        Student current = this.head;
        if (current == null || n < 0){
            return;
        }
        int indx = 0;
        while (current != null && indx < (n-1)){
            current = current.next;
            indx++;
        }
        if(current == null || current.next == null){
            return;
        } 
        current.next = current.next.next;
    }
}


public class PruebaLinkedList {
    public static void main(String[] args) {
        LnkdList lista = new LnkdList();
        lista.add("Airam",99);
        lista.add("Sergio", 88);
        lista.add("Alfedo", 81);
        System.out.println("agregados.");
        
        lista.print();
        
        Student found = lista.retrieve("Airam");
        System.out.println("Found: " + found.name + "score: " + found.score);
        
        Student notfound = lista.retrieve("Alguien");
        if (notfound != null){
            System.out.println("Found: " + notfound.name + "score: " + notfound.score);
        }
        
        lista.remove(1);
        lista.print();
    }
    
}
