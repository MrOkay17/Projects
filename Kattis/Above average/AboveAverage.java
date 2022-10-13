import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AboveAverage
 */
public class AboveAverage {

    private Scanner sc;
    private File file;
    private ArrayList<Integer> list;

    public AboveAverage() throws FileNotFoundException {
        file = new File("file");
        sc = new Scanner(file);
        sc.nextLine();
        list = new ArrayList<>();

    }

    public void CalculateAverage() throws FileNotFoundException {

        while (sc.hasNextLine()) {
            String[] Array = sc.nextLine().split(" ");

            for (String string : Array) {
                list.add(Integer.valueOf(string));
            }

            float persons = Integer.valueOf(list.get(0));
            list.remove(0);

            float sum = 0;

            for (Integer grade: list) {sum += grade;}
            
            float average = sum / persons;

            float counter = 0;

            for (Integer integer : list) {
                if (Integer.valueOf(integer) > average) {
                    counter++;
                }
            }
        
            float percentage = (counter / persons) * 100;
            
            String result = String.format("%.3f", percentage);
            result = result.replace(",", ".");
            System.out.println(result +"%");

            list.removeAll(list);
            
            }

        }

    
  
    public static void main(String[] args) throws FileNotFoundException {
        AboveAverage calculate = new AboveAverage();
        calculate.CalculateAverage();
    }
}