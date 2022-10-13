import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ahh1 = sc.nextLine();
        String ahh2 = sc.nextLine();


        if (ahh1.length() >= ahh2.length())
         System.out.println("go");
        
        else
        System.out.println("no");


        sc.close();
    }
}