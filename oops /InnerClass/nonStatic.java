class Outer{
    private String msg = "this is Outer class ";
    class Inner{
        void show(){
            System.out.println(msg);
        }
    }
}

public class nonStatic{
    public static void main ( String [] args ){
        Outer out = new Outer();

        Outer.Inner in = out.new Inner();

        in.show();
    }
} 