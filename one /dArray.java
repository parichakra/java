// #creating array of 10 element and deleting one 
import java.util.Scanner;

public class dArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];

        System.out.println("Enter array of 10 elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter any position to delete: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 10) {
            System.out.println("Invalid position!!!");
        } else {
            System.out.println("Array after deleting position " + x + ":");
            for (int i = 0; i < array.length; i++) {
                if (i != x - 1) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
