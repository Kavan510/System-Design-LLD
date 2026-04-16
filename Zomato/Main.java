package Zomato;

import javax.sound.sampled.SourceDataLine;
import javax.swing.event.SwingPropertyChangeSupport;

import Zomato.models.Order;
import Zomato.models.User;
import Zomato.strategies.*;
import Zomato.models.Restaurant;
import Zomato.models.*;
import java.util.*;
import Zomato.models.*;

public class Main {

    public static void main(String[] args) {
        ZomatoApp zomato = new ZomatoApp();

        User user = new User("Kavan", "Bvn", 101);
        System.out.println("User with user id " + user.getName() + " is active\n");
        java.util.List<Restaurant> restaurantList = zomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurant found!!");
            return;
        }
        System.out.println("Found restaurant\n");

        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        zomato.selectRestaurant(user, restaurantList.get(0));

        System.out.println("Selected Restaurant:" + restaurantList.get(0).getName());
        zomato.addToCart(user, "P1");
        zomato.addToCart(user, "P2");
        zomato.printUserCart(user);
        Order order = zomato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));

        zomato.payForOrder(user, order);

    }
}
