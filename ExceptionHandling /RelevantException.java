//wap to get two integer number and perform division handling all relevant exception

import java.util.*;

class RelevantException{
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        try{
            System.out.print("Enter first integer: ");
            int a = scan.nextInt();
            
            System.out.print( " enter second intefer:  ");
            int b = scan.nextInt();

            int division = a/b;

            System.out.println("The division is : "+ division);
        }catch(ArithmeticException e ){
            System.out.println( e.getMessage());
        }catch(InputMismatchException e ){
            System.out.println("enter only integer");
        }finally{
            System.out.println(" \n end");
        }

    }
}