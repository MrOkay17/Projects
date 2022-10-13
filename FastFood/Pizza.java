import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {

    protected List<String> toppings;

    public Pizza() {
        super("Pizza", 45);
        this.toppings = new ArrayList<>();

    }

    public void addTopping(String topping) {
        toppings.add(topping);
        price += 10;
    }
    
    @Override
    public void display(){
        super.display();
        String seperator = ", ";
        String print = "";

        if (toppings.isEmpty()) {
            String print3 = "";
            System.out.print(" { " + print3 + " } ");
        }
        else {
            for (String string : toppings) {
                print += string;
                print += seperator;
            }
            String print2 = print.substring(0, print.length()-2);
    
            System.out.print(" { " + print2 + " } ");
        }
       
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
