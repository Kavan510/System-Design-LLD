package Zomato.models;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Cart {

private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart() {

        restaurant = null;
    }

    public void addItem(MenuItem item) {
        if (restaurant == null) {
            System.err.println("add restauratn before adding item");
        }

        items.add(item);
    }
    public double getTotalCost() {
        double cost = 0;
        for (MenuItem it : items) {
            cost += it.getPrice();
        }

        return cost;

    }

    public boolean isEmpty() {
        return restaurant == null || items.isEmpty();
    }

    public void clear() {
        items.clear();
        restaurant=null;
    }

    public void setRestaurant(Restaurant n) {
        this.restaurant = n;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

}
