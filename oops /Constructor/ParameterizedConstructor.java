class Student{ 
    String name;
    int age;


    Student( String n, int a ){
        name = n;
        age = a;
    }

    void display(){
        System.out.println("Name: "+ name + ", Age "+ age);
    }
}


public class ParameterizedConstructor{
    public static void main( String [] args){
        Student s1 = new Student( "Ram", 21);
        Student s2 = new Student( " Sita", 26);

        s1.display();
        s2.display();
    }
}