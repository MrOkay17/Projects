import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] Splitted = sc.nextLine().split(" ");

        int a = Integer.parseInt(Splitted[0]);
        int b = Integer.parseInt(Splitted[1]);
        int c = Integer.parseInt(Splitted[2]);

        for (int i = 1; i <= c; i++) {
            if (i % a == 0 & i % b == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % a == 0) {
                System.out.println("Fizz");
            }
            else if (i % b == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
            
        }


        sc.close();
    }
}