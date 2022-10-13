/**
 * Main
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        int minuets = sc.nextInt();
        
        int difference = minuets - 45;

        if (difference < 0){
            minuets = 60 + difference;
            if(hours == 0)
                hours = 24;
                System.out.println(hours - 1 + " " + minuets);

            }
        
        
        else 
            System.out.print(hours + " " + difference);

        


        sc.close();
    }

        
    }
