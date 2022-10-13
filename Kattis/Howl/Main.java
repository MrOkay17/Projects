
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String howl = sc.nextLine();

        System.out.print("AWH" + "O".repeat(howl.length()));
    }
}

