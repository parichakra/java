class Student {
    String name ;

    Student( String name ){
        this.name = name;
    }

    void display(){
        System.out.println("Student name : "+ this.name);
    }
}

public class ThisKeyword{
    public static void main ( String [] args){
        Student s = new Student("Ram");
        s.display();
    }
}