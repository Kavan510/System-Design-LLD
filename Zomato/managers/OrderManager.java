package Zomato.managers;

import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;
import Zomato.models.*;
import Zomato.models.Order;

public class OrderManager {
    
    private static OrderManager instance = null;
    private List<Order> orders = new ArrayList<>();

    private OrderManager() {

    }

    public static OrderManager getInstance() {
        if(instance==null) {
            instance =new OrderManager();
        }
        return instance;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        System.out.println("-- All Orders------\n");
     for (Order order : orders) {
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }

}
