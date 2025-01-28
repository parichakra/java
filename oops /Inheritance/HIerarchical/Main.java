class Animal{
    void eat(){
        System.out.println("animal eats food");
    }
}

class Cat extends Animal {
    void meow(){
        System.out.println("the cat meow");
    }
}

class Dog extends Animal {
    void bark(){
        System.out.println("The dog barks");
    }
}

class Main{
    public static void main(String [] args){
        Dog mydog = new Dog();
        Cat mycat = new Cat();

        mydog.eat();
        mydog.bark();

        mycat.eat();
        mycat.meow();

    }
}