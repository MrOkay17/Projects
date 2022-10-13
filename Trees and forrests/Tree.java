public class Tree {
    /*
     Add the following three private fields to the Tree class:

        age of type int: the tree's age in years.
        height of type double: the tree's height in meters.
        growthPct of type double: the tree's growth per year as a percentage.
     
     */
    
    private int age;
    private double height;
    private double growthPct;

    /*
     Create a constructor for the class Tree(double growthPct), taking a single parameter of type double. The constructor must set the initial height to be 0.25 meters, and the age to be 1 year, and the growth rate to be the parameter given to the constructor.
     */
    public Tree(double growthPct){
        height = 0.25;
        age = 1;
        this.growthPct = growthPct;
    
    }

    /*
     Create a public toString() method that returns a String with the format: "Tree(age = 1, height = 0.25)", where 1 and 0.25 are substituted with what the value of the corresponding fields are.
     */

    public String toString(){
        return ("Tree(age = " + this.age + ", height = " + this.height + ")");
    }

    /*
     Create a public method growOneYear(), which increases the age by one, and increases the height of the tree according to the formula height * (1 + growthPct / 100).
     */

    public void growOneYear(){
        this.age++;
        this.height = this.height * (1 + this.growthPct / 100);

        //Modify the growOneYear() method such that a tree will stop growing once it reaches a height of 20 meters.

        if (this.height >= 20){
            this.height = 20;
        } 



    }

}
