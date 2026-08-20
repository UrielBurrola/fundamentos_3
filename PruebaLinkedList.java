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
}


public class PruebaLinkedList {
    public static void main(String[] args) {
        LnkdList lista = new LnkdList();
        lista.add("Airam",99);
        lista.add("Sergio", 88);
        lista.add("Alfedo", 81);
        System.out.print("agregados.");
    }
    
}
