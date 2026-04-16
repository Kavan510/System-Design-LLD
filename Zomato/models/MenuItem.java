package Zomato.models;

public class MenuItem {
    private int price;
    private String name;
private String code;

public MenuItem(String name,String code, int price){
    this.name=name;
    this.price=price;
    this.code=code;
}

public String getCode() {
        return code;
    }

    public void setCode(String c) {
        code = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int p) {
        price = p;
    }



}
