import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < cases; i++) {
            list.add(sc.nextLine());        
            
        }
        
        ArrayList<String> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        
        ArrayList<String> list3 = new ArrayList<>(list2);
        Collections.reverse(list3);

        if (list.equals(list2)) {
            System.out.println("INCREASING");
            }
        
        else if (list3.equals(list)){
            System.out.println("DECREASING");
        }
        else {
            System.out.println("NEITHER");
        }

        sc.close();
    }
}