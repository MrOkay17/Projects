import java.util.*;
import java.io.*;

/**
 * ShoppingList
 */
public class ShoppingList_gammel {
    public static void main(String[] args) throws FileNotFoundException {
    File file = new File("test.txt");
    
    
    Scanner sc = new Scanner(file);
    //Scanner sc = new Scanner(System.in);
        
    Map<String, Integer> Avaliable = new TreeMap<>();
    Map<String, Integer> Recipes = new TreeMap<>();
    Map<String, Integer> Shoppinglist = new TreeMap<>();


    sc.nextLine();
    
    int swiiitch = 0;

    while (sc.hasNextLine()) {
        String nextline = sc.nextLine();
        
        if (nextline.isEmpty()) {
            break;
        }

        if (nextline.contains("RECIPE")) {
            swiiitch = 1;
        }

        if (swiiitch == 0) {
            String[] list = nextline.split(" ");

                int grams = Integer.parseInt(list[0]);
                
                if (list[1].equals("kg")) {
                    grams = grams * 1000;
                    Avaliable.put(list[2], grams);
                }
                else {
                    Avaliable.put(list[2], grams);
                }
            
        }
        
        else if (swiiitch == 1 && !nextline.contains("RECIPE")) {
                String[] list2 = nextline.split(" ");

                int grams2 = Integer.parseInt(list2[0]);

                if (Recipes.containsKey(list2[2])) {

                    if (list2[1].equals("kg")) {
                        grams2 = grams2 * 1000;
                        Recipes.replace(list2[2], Recipes.get(list2[2]), Recipes.get(list2[2]) + grams2);
                    
                    }
                    else {
                    int grams_to_integer = Integer.parseInt(list2[0]);
                    Recipes.replace(list2[2], Recipes.get(list2[2]), Recipes.get(list2[2]) + grams_to_integer);
                    }
                }
                        
                else {
                    if (list2[1].equals("kg")) {
                        grams2 = grams2 * 1000;
                        Recipes.put(list2[2], grams2);
                    }
                    else {
                        Recipes.put(list2[2], grams2);
                    }

                }

            
        }
                
    
    }

    for (String items : Recipes.keySet()) {

        if (Avaliable.containsKey(items)) {
            if (Avaliable.get(items) != Recipes.get(items)) {
                if (Recipes.get(items) > Avaliable.get(items)) {
                    int value_of_containing = Recipes.get(items) - Avaliable.get(items);
                    Shoppinglist.put(items, value_of_containing);
                }
            }

        }
        else {
            Shoppinglist.put(items, Recipes.get(items));
        }

        
    }

    System.out.println("Shopping List:");
    for (String print : Shoppinglist.keySet()) {
        
        System.out.println(Shoppinglist.get(print) + " g " + print);
        
    }


        
    }

}



    
