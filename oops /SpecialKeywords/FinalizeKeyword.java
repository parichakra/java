class Demo{
    Demo(){
        System.out.println("Object created ");
    }

    public void finalize(){
        System.out.println("object is being destroyed");
    }
}


public class FinalizeKeyword{
    public static void main( String [] args){
        Demo obj1= new Demo();
        Demo obj2= new Demo();

        obj1= null;
        obj2 = null ; //marking obbject for garbage collection

        System.gc(); //Request garbage collectionn 


    }

    
}