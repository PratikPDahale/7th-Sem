import java.util.ArrayList;
import java.util.List;

class Item{
    double value, weight, ratio;

    public Item(double value, double weight){
        this.value = value;
        this.weight = weight;
        this.ratio = value/weight;
    }
}

public class Exp3 {
    public static double fractionalKnapsack(double capacity, double[] values, double[] weights){
        int n = values.length;
        List<Item> items = new ArrayList<>();

        //Step 1: Create list of items
        for(int i = 0; i < n; i++){
            items.add(new Item(values[i], weights[i]));
        }

        //Step 2: Sort items by value/weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;

        for(Item item : items){
            if(capacity >= item.weight){
                //Take full item
                capacity -= item.weight;
                totalValue += item.value;
            }else{
                //Take fraction of item
                totalValue += item.value * (capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        double[] values = {60, 100, 120};
        double[] weights = {10, 20, 30};
        double capacity = 50;

        double maxValue = fractionalKnapsack(capacity, values, weights);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
