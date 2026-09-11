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
    Student tail;
    int index;

    public LnkdList(){
        this.head = null;
        this.tail = null;
        this.index = 0;
    }

    public void add(String name, int score){
        Student newStudent = new Student(name,score);
        if (head == null){
            this.head = newStudent;
            this.tail = newStudent;
            this.index++;
        } else {
            this.tail.next = newStudent;
            this.tail = newStudent;
            index++;
        }
    }

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

        if (current == null || n < 0){ //Empty list y Negative Index
            return;
        }
        if (n >= this.index){ //Idex out of bounds
            return;
        }
        if (n == 0){ //Remove head
            this.head = this.head.next;
            this.index--;
            return;
        }
        if (n == this.index-1){//Remove tail
            while(current.next != this.tail){
                current = current.next;
            }
            current.next = null;
            this.tail = current;
            index--;
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
        this.index--;
    }
}


public class PruebaLinkedList {
    public static void main(String[] args) {
        LnkdList lista = new LnkdList();

        lista.remove(0);

        lista.add("Airam",90);
        lista.add("Sergio", 88);
        lista.add("Alfedo", 81);
        lista.add("Luis", 100);

        System.out.println("agregados.");

        lista.print();

        lista.remove(2);

        lista.remove(3);

        lista.remove(2);

        lista.print();

        Student found = lista.retrieve("Airam");
        System.out.println("Found: " + found.name + "score: " + found.score);

        Student notfound = lista.retrieve("Alguien");
        if (notfound != null){
            System.out.println("Found: " + notfound.name + "score: " + notfound.score);
        }

        lista.remove(2);
        lista.print();

        System.out.println("After delete Alfedo");

        lista.remove(2);
        lista.print();

    }

}