import java.util.*;
public class Box {
    private int position;
    private int destination;
    private String label;

    public Box(int destination, String label){

        this.label = label;
        this.destination = destination;
        this.position = 0;

    }

    public int getPosition() {
        return this.position;
        
    }
    
    public int getDestination() {
        return this.destination;
        
    }

    public String getLabel() {
        return this.label;
    }

    public void forward() {
        position += 1;
    }

   @Override
   public String toString(){
    return "position: " + this.position + ", label: " + this.label;

   } 

   




    
}
