import java.util.Scanner;

/**
 * Soda
 */


public class Soda {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            int e = sc.nextInt();
            int f = sc.nextInt();
            int c = sc.nextInt();


            int emptyBottles = e + f;
            int total = 0;

            while (emptyBottles >= c) {
                emptyBottles = emptyBottles - c + 1;
                total = total + 1;
            } 
            
            System.out.println(total);

            sc.close();
            
        }


        
        
            
            
        }


