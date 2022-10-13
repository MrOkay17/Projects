import java.util.Scanner;

public class Reversed {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int in = sc.nextInt();
            String s = Integer.toBinaryString(in);

            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();

            System.out.println(Integer.parseInt(s, 2));
            
            sc.close();
        }
        
    }

