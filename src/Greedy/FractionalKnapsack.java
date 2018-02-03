package Greedy;


import java.util.Arrays;
import java.util.Comparator;

/*
 *  Q:0-1Knapsack problem, but we can break items for maximizing total val
 *  Thought Process: 
bf: try all subset with dif fraction
 *  Get:
greedy: cal ratio for each item (val/w)
        sort them by ratio
        take itm with highest ratio & add until we can't add the nxt as whole
        add the nxt as much as we can
 */

/**
 *
 * @author xinrong
 */
class Item {
    int value;
    int weight;
    Item(int v, int w) {
        value = v;
        weight= w;
    }
}
public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item[] items) {
        Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                int r1 = i1.value / i1.weight;
                int r2 = i2.value / i2.weight;
                return r2 - r1;
            }
        });
        int curw = 0, totalv = 0;
        for (int i = 0; i < items.length; i++) {
            if (curw + items[i].weight <= W) {
                curw   += items[i].weight;
                totalv += items[i].value;
            } else {
                int remain = W - curw;
                totalv += items[i].value * ((double)remain / items[i].weight);
                break;
            }
        }
        return totalv;
    }
}
