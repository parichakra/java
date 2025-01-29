public class FinallyKeyword{
    public static void main ( String [] args){
        try{ 
            System.out.println("inside try block");
            int a = 100/0;

        }catch (ArithmeticException e) {
            System.out.println( "Exception  caught"+  e);
        }finally{
            System.out.println( "Final block executed");
        }
    }
}