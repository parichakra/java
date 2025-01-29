//example program of compiled time polymorphism ( method overloading )
class calculate {
    //method with two parameters
    public int add( int a, int b){
        return a+b;
    }

    //method with three parameters
    public int add( int a, int b, int c){
        return a+b+c;
    }

    //public class with double datatype 
    public double add(double a, double b ){
        return a+b;
    }
}

public class CompiledTimePolymorphism{
    public static void main ( String [] args){

        calculate calc = new calculate();

        System.out.println( calc.add(5,10));
        System.out.println( calc.add(5,10,15));
        System.out.println( calc.add(5.2,10.3));

    }
}