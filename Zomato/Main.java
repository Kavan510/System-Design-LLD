package Zomato;

import Zomato.models.*;
import Zomato.strategies.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Single instance (IMPORTANT FIX)
        ZomatoApp zomato = new ZomatoApp();

        // Create user
        User user = new User("Kavan", "Bvn", 101);
        System.out.println("User with userName " + user.getName() + " is active\n");

        // Search restaurants
        List<Restaurant> restaurantList = zomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurant found!!");
            return;
        }

        System.out.println("Found restaurant\n");

        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        // Select restaurant
        Restaurant selectedRestaurant = restaurantList.get(0);
        zomato.selectRestaurant(user, selectedRestaurant);

        System.out.println("Selected Restaurant: " + selectedRestaurant.getName());

        // Add items to cart
        zomato.addToCart(user, "P1");
        zomato.addToCart(user, "P2");

        // Print cart
        zomato.printUserCart(user);

        // Checkout
        Order order = zomato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));

        // Pay
        zomato.payForOrder(user, order);
    }
}