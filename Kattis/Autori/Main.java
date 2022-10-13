/**
 * Main
 */
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] splitted = input.split("-");

        String empty = "";

        for (String string : splitted) {
            empty += string.charAt(0);
        }
        System.out.println(empty);

        sc.close();
    }
}