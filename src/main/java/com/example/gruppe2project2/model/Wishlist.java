package com.example.gruppe2project2.model;


public class Wishlist {



    int id;
    int user_id;
    String itemName;

    public Wishlist(int id, int user_id, String itemName) {
        this.id = id;
        this.user_id = user_id;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

