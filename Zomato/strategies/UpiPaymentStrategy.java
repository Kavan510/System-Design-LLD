package Zomato.strategies;

public class UpiPaymentStrategy implements PaymentStrategy{
    private String upiId;

    public UpiPaymentStrategy(String id) {
        this.upiId=id;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹ "+ amount +"is done using upi id"+ upiId);
    }
}
