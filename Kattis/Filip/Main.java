import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] Splitted = input.split( " ");

        int number1 = Integer.parseInt(Splitted[0]);
        
        int number2 = Integer.parseInt(Splitted[1]);

        int reversedNumber = 0;
        int numberToReverse = Math.abs(number1);

        while (numberToReverse > 0) {
            int mod = numberToReverse % 10;
            reversedNumber = reversedNumber * 10 + mod;
            numberToReverse /= 10;
        }

        int reversedNumber2 = 0;
        int numberToReverse2 = Math.abs(number2);

        while (numberToReverse2 > 0) {
            int mod = numberToReverse2 % 10;
            reversedNumber2 = reversedNumber2 * 10 + mod;
            numberToReverse2 /= 10;
        }

        if (reversedNumber > reversedNumber2){
            System.out.print(reversedNumber);
        }
        else {
            System.out.println(reversedNumber2);
        }


        sc.close();


    }

    
}