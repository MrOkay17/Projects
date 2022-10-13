import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//mikkels gren
        String[] input = sc.nextLine().split("");

        int empty = 1;

        for (int i = 0; i < input.length; i++) {

            if (input[i].equals("A")) {
                if (empty == 2) {
                    empty = 1;
                }
                else if (empty == 1) {
                    empty = 2;
                    
                }
                
            }
            else if (input[i].equals("B")) {
                if (empty == 3) {
                    empty = 2;
                }
                else if (empty == 2) 
                {
                    empty = 3;
                }
                
            }
            else if (input[i].equals("C")) {
                if (empty == 1) {
                    empty = 3;
                    
                }
                else if (empty == 3)
                {
                    empty = 1;
                }
            }
           
        }
        System.out.println(empty);


        sc.close();
    }
}