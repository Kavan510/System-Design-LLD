package Zomato.models;

public class PickupOrder extends Order {
    private String pickupAddress;

    public PickupOrder(){
        pickupAddress = "";
    }
@Override
    public String getType() {
        return "pickup";
    }

    public void setAddress(String add) {
        pickupAddress=add;
    }

    public String getAddress(){
        return pickupAddress;
    }

}
