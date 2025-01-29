class Outer {
    static String msg = " this is outer class ";

    static class StaticNestedclass{
        void show(){
            System.out.println(msg);

        }
    }
}

public class staticInnerClass{
    public static void main ( String [] args){
        Outer.StaticNestedclass nest= new Outer.StaticNestedclass();

        nest.show();
    }
}