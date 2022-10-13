import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input1 = Integer.parseInt(sc.nextLine());
        int input2 = Integer.parseInt(sc.nextLine());

        int total = 0;

        for (int i = 0; i < input2; i++) {
            total += Integer.parseInt(sc.nextLine());
        
        }
        System.out.println(input1*(input2+1)-total);
        
        sc.close();
    }
    
}