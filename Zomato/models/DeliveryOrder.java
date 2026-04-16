package Zomato.models;

public class DeliveryOrder extends Order {
    private String userAddress;

    public DeliveryOrder(){
        userAddress="";
    }

    @Override

    public String getType() {
        return "delivery";
    }

    public void setAddress(String add) {
        userAddress=add;
    }
    public String getAddress(){
        return userAddress;
    }

}
