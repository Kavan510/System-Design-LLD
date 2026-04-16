package Zomato.factories;
import java.util.*;
import java.security.DrbgParameters.Reseed;
import java.util.List;
import java.util.concurrent.TimeUnit;
import Zomato.models.*;
import Zomato.strategies.PaymentStrategy;

public class NowOrderFactory implements OrderFactory {

    @Override

    public Order createOrder(User user,Cart cart, Restaurant restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy,
            double total, String orderType){
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
                order.setScheduled(java.time.LocalDateTime.now().toString());
                return order;

            }

}
