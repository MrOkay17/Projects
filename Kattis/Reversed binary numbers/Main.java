import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        String inputBinary = Integer.toBinaryString(input);

        int Input_binary_int = Integer.parseInt(inputBinary);

        int reversedNumber = 0;

        while (Input_binary_int > 0) {
            int mod = Input_binary_int % 10;
            reversedNumber = reversedNumber * 10 + mod;
            Input_binary_int /= 10;
        }

        String As__a_String = Integer.toString(reversedNumber);

        int as_decimal = Integer.parseInt(As__a_String,2);

        System.out.println(as_decimal);



        sc.close();

    }
}