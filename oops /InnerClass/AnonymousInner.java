interface Anonyms{
    void show();
}

public class AnonymousInner{
    public static void main ( String [] args ){
        Anonyms anyms = new Anonyms(){
            // @override
            public void show(){
                System.out.println("Hello from anynomous class ");
            }
        };
        anyms.show();
    }
}