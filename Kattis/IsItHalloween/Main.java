import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String month = sc.nextLine();


        if (month.equals("OCT 31") || month.equals("DEC 25"))
         System.out.println("yup");
        
        else
        System.out.println("nope");


        sc.close();
    }
}