// function to take an array of integers as an argument and return sum of even 
// numbers in that array

import java.util.Scanner;

public class EvenFromArray{


    private static Scanner sc;

    public static void main ( String [] args ){
        int size, i , Esum= 0;

        sc = new Scanner( System.in);

        System.out.print("please enter number of element in an array ");

        size = sc.nextInt();
        int[] a = new int[size];

        System.out.print("please enter  "+ size + " array elements \n" );

        for(  i =0 ; i< size; i++){
            a[i]= sc.nextInt(); 

        }
        
        for ( i=0 ; i<size ; i++){
            if (a[i]%2 == 0) {  
                Esum = Esum + a[i];
            }
        }
        System.out.println( "\n The sum of even number in this array =" + Esum);

    }
}