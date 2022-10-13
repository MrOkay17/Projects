import java.util.*;
import java.io.*;

public class ShoppingList {
    
    private TreeMap<String, Integer> Avaliable;
    private TreeMap<String, Integer> Recipes;
    private TreeMap<String, Integer> Shoppinglist;

    private File file;
    private Scanner sc;

//Constructer
public ShoppingList() throws FileNotFoundException{
    Avaliable = new TreeMap<>();
    Recipes = new TreeMap<>();
    Shoppinglist = new TreeMap<>();
   
    file = new File("test.txt");
    sc = new Scanner(file);
    // sc = new Scanner(System.in);
    sc.nextLine();
}

public void Addingtotreemaps() throws FileNotFoundException {
    int swiiitch = 0;

    while (sc.hasNextLine()) {
        String[] nextline = sc.nextLine().split(" ");
        
        if (nextline[0].isEmpty()) {
            break;}

        if (nextline[0].contains("RECIPE")) {
            swiiitch = 1;
            continue;}

        int grams = Integer.parseInt(nextline[0]);

        if (nextline[1].equals("kg")){
            grams = grams *= 1000;}
        
        if (swiiitch == 0) {
                    Avaliable.put(nextline[2], grams);}
        
        else if (swiiitch == 1) {
                if (Recipes.containsKey(nextline[2])) {
                        Recipes.replace(nextline[2], Recipes.get(nextline[2]) + grams);}
       
                else {
                        Recipes.put(nextline[2], grams);}
                }
        }
    }

public void puttingitemstonewtreemap(){
    
    for (String items : Recipes.keySet()) {

        if (Avaliable.containsKey(items)) {
            if (Avaliable.get(items) != Recipes.get(items)) {
                if (Recipes.get(items) > Avaliable.get(items)) {
                    int value_of_containing = Recipes.get(items) - Avaliable.get(items);
                    Shoppinglist.put(items, value_of_containing);}
            }
        }
        else {
            Shoppinglist.put(items, Recipes.get(items));}
    }
}

public void print(){
    System.out.println("Shopping List:");
    for (String print : Shoppinglist.keySet()) {
        System.out.println(Shoppinglist.get(print) + " g " + print);
        
    }
}

public static void main(String[] args) throws FileNotFoundException {
    ShoppingList letsgoshopping = new ShoppingList();
    letsgoshopping.Addingtotreemaps();
    letsgoshopping.puttingitemstonewtreemap();
    letsgoshopping.print();}   
}
