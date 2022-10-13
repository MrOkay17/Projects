import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfCups = sc.nextInt();

        TreeMap<Integer, String> newtreemap = new TreeMap<>();

        for (int i = 0; i < numberOfCups; i++) {
            
            if (sc.hasNextInt()) {
                int integer1 = sc.nextInt() / 2;
                String string1 = sc.next();
                newtreemap.put(integer1, string1);
            
            
            }
            
            else {
                String string2 = sc.next();
                int integer2 = sc.nextInt();
                newtreemap.put(integer2, string2);

            }


        }
       
        for (Map.Entry<Integer, String> entry : newtreemap.entrySet()){
            System.out.println(entry.getValue());
        }


        sc.close();
    }
}

