class Animal {
    public void sound (){
        System.out.println("Animals makes sound ");
    }
}

class Dog extends Animal {
    public void sound(){
        super.sound();
        System.out.println("Dog barks  ");

    }
}

public class SuperKeyword{
    public static void main ( String [] args){
        Animal a = new Dog();
        a.sound();
    }
}