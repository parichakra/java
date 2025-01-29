//interfae using polymorphism 

interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println("Drawing a Rectangle");
    }
}

public class PolymorphismUsingInterface{
    public static void main ( String [] args){
        Shape shape;

        shape= new Circle();
        shape.draw();

        shape= new Rectangle();
        shape.draw();
    }
}