import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Inputs 
        int cases = Integer.parseInt(sc.nextLine());

        //Forloop that check for cases
        for (int i = 0; i < cases; i++) {
            StringBuilder sb = new StringBuilder();
            char[] line1 = sc.nextLine().toCharArray();
            char[] line2 = sc.nextLine().toCharArray();

            for (int j = 0; j < line1.length; j++) {
                
                if (line1[j] == line2[j]){
                sb.append(".");
                }
                
                else{
                    sb.append("*");
                }
                
                
            }

            for (char c : line1) {
                System.out.print(c);
                
            }
            
            System.out.println();
            
            for (char p : line2) {
                System.out.print(p);
                
            }

            System.out.println();
            System.out.println(sb);
            System.out.println();

            
        }



    


        sc.close();


    }

    
}
