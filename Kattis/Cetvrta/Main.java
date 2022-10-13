import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] array = new int [2][3];

        array [0][0] = sc.nextInt();
        array [1][0] = sc.nextInt();
        array [0][1] = sc.nextInt();
        array [1][1] = sc.nextInt();
        array [0][2] = sc.nextInt();
        array [1][2] = sc.nextInt();

        for (int i = 0; i < 2; i++) {
            int first = array[i][2];
            if (array[i][1] == first) {
                System.out.println(array[i][2] + " ");   
            }
            else if (array[i][2] == first) {
                System.out.println(array[i][1] + " ");   
            }
            else {
                System.out.println(first +  " ");
            }
            
        }

        sc.close();

    }
}