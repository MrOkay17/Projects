import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();

        String count = sc.nextLine();

        String[] seperated_count = count.split(" ");

        boolean check = false;

        for (int i = 0; i < seperated_count.length; i++) {
            if (seperated_count[i].equals("mumble") | seperated_count[i].equals(Integer.toString(i+1))) 
                continue;
                check = true;
            
        }
        System.out.println(check? "something is fishy" : "makes sense");

        sc.close();

    }
}