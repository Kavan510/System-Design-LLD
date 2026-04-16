package Zomato.factories;

import Zomato.models.MenuItem;
import Zomato.strategies.PaymentStrategy;
import Zomato.models.Restaurant;
import Zomato.models.*;
import java.util.*;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant,List<MenuItem> items,PaymentStrategy paymentStrategy,double total, String orderType);
}
