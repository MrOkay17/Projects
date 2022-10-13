import java.util.*;
import java.io.*;

/**
 * JobSwitching
 */
public class JobSwitching {

    private Scanner sc;
    private ArrayList<Integer> Integer_list;

    public JobSwitching() {
        sc = new Scanner(System.in);
        Integer_list = new ArrayList<>();

    }

    public void name() {
        int jobs = Integer.parseInt(sc.nextLine());
        String[] list = sc.nextLine().split(" ");
        
        for (String string : list) {
            Integer_list.add(Integer.parseInt(string)); 
        }
        
        int counter = 0;

        for (int i = 0; i < jobs ; i++) {
            
            if (!(Integer_list.get(i) - (i+1) == 0)) {
                
                int diff = Integer_list.get(i) - (i + 1);

                int num1 = Integer_list.get(i);
                int num2 = Integer_list.get(i+diff);

                Integer_list.set(i+diff,num1);
                Integer_list.set(i, num2);

                counter ++;
                i--;
            }

        }
        System.out.println(counter);
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        JobSwitching letstry = new JobSwitching();
        letstry.name();
        
    }
}