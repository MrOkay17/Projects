import java.util.ArrayList;

public class Forest {
   
    //Field - Arraylist
    private ArrayList<Tree> trees;

    //Constructor named forest
    public Forest()
    {
        trees = new ArrayList<Tree>();

    }
    // Method that adds a tree to the list
    public void addTree (int growthPct){
        trees.add(new Tree(growthPct));
    }
    //Method that returns a String with the format: Forest(Tree(age = 1, height = 0.25)Tree(age = 1, height = 0.25)Tree(age = 1, height = 0.25))
    public String toString(){
        
        String string = "Forest(";

        for (Tree tree : trees) {
            string = string + tree.toString();
        }
        return string + ")";

    }
    
    // Create a growOneYear() method that causes all the trees in the forrest to grow by one year.
    public void growOneYear(){
        for (Tree tree : trees) {
            tree.growOneYear();
        }

    }


   
}
