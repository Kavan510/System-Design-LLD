package Zomato.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    
private String cardNumber;


public CreditCardPaymentStrategy(String cardNo) {
this.cardNumber=cardNo;
}


@Override
public void pay(double amount){
    System.out.println("Payment of ₹ "+ amount+ "is done with Credit Card with no." + cardNumber);
}

}
