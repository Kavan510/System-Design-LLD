package Zomato.models;

public class User {
    
    private int userId;
    private String name;
    private String address;
    private Cart cart;

    public User(String name,String address,int userId){
        this.name = name;
        this.address=address;
        this.userId = userId;

        this.cart = new Cart();
    }
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress(){
        return address;
    }
public void setAddress(String add) {
    address=add;
}

public Cart getCart(){
    return cart;
}
}
