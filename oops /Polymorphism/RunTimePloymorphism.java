//example to show run time polymorphism ( method overriding )

 class Animal {
    public void sound(){
        System.out.println("Animal make sound");
    }
}

 class Cat extends Animal{
    
    public void sound(){
        
        System.out.println("Cat Meow");
        
    }
}

public class RunTimePloymorphism{
    public static void main (String [] args){
        Cat c= new Cat();

        c.sound();
    }
}