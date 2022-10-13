import java.util.ArrayList;
import java.util.List;

public class Order {
    
    protected List<Food> ordered;


    public Order() {
        this.ordered = new ArrayList<>();
    }

    public void addFood(Food food) {
        ordered.add(food);
    }

    public int total() {
        int sum = 0;

        for (Food food : ordered) {
            sum += food.price;
        }
        return sum;
        
    }

    public void display() {
        for (Food food : ordered) {
            food.display();
        }
        
        System.out.println(total() + " kr TOTAL");
        
    }

    public boolean payWith(CreditCard card) {
        if (card.withdraw(total()) == true ) {
            return card.withdraw(total());
        }
        else{
            System.out.println("ERROR: Payment failed");
            return card.withdraw(total());
        }
    }

}
        
