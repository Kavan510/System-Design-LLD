package Zomato.factories;

import java.util.List;

import Zomato.models.DeliveryOrder;
import Zomato.models.MenuItem;
import Zomato.models.Order;
import Zomato.models.PickupOrder;
import Zomato.models.Restaurant;
import Zomato.models.User;
import Zomato.strategies.PaymentStrategy;
import Zomato.models.*;
public class ScheduleOrder implements OrderFactory {
    private String scheduleTime;

    public ScheduleOrder(String scheduleTime) 
    {
        this.scheduleTime=scheduleTime;
    }


    @Override
       public Order createOrder(User user,Cart cart,Restaurant restaurant,List<MenuItem> items,PaymentStrategy paymentStrategy,double total, String orderType){
            Order order=null;


                if(orderType.equals("delivery")) {
                    DeliveryOrder deliveryOrder = new DeliveryOrder();
                    deliveryOrder.setAddress(user.getAddress());
                    order=deliveryOrder;
                }
                else{
                    PickupOrder pickupOrder= new PickupOrder();
                    pickupOrder.setAddress(restaurant.getLocation());
                    order = pickupOrder;
                }

                order.setUser(user);
                order.setRestaurant(restaurant);
                order.setItems(items);
                order.setPaymentStrategy(paymentStrategy);
                order.setTotal(total);
                order.setScheduled(scheduleTime);
                return order;


        }
}
