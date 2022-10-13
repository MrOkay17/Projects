
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < 10; i++)
            if(set.add(sc.nextInt() % 42))
                count++;
        System.out.println(count);
    }
}
