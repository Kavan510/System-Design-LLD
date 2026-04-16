package Zomato.models;


import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Restaurant{


    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();


    private static int nextRestauratnId = 0;
    
    public Restaurant(String name,String location){
        this.name = name;
        this.location = location;
        this.restaurantId = ++nextRestauratnId;
    }

    public String getName(){
        return name;
    }
    public void setName(String n) {
        name=n;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String add) {
        location=add;
    }

public List<MenuItem> getMenu(){
    return menu;
}

public void addMenuItem(MenuItem item) {
    menu.add(item);
}



}