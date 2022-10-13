import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaCrowds2 {
    private Scanner sc;
    private File file;
    private ArrayList<Integer> list;
    

    public CinemaCrowds2() throws FileNotFoundException {
    //file = new File("file");
    sc = new Scanner(System.in);
    list = new ArrayList<>();

}

public void name() throws FileNotFoundException {
    String input1 = sc.nextLine();
    String input2 = sc.nextLine();

    String[] Splitted1 = input1.split(" ");
    String[] Splitted2 = input2.split(" ");

    int seats = Integer.parseInt(Splitted1[0]);
    int groups = Integer.parseInt(Splitted1[1]);

    for (String string : Splitted2) {list.add(Integer.valueOf(string));}
    
    int counter = 0;
    int sum = 0;
    for (int i = 0; i < groups; i++) {
        if (list.get(i) <= 10 && list.get(i) >= 1) {
            sum += list.get(i);
            
            if (sum > seats) {
                counter++;
            }
            
        }
        else if (list.get(i)> 10) {
            counter++;
            
        }
            
    }
    System.out.println(counter);

}

public static void main(String[] args) throws FileNotFoundException {
    CinemaCrowds2 result = new CinemaCrowds2();
    result.name();
}
    
}
