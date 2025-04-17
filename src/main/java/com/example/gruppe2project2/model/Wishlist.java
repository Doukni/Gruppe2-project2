package com.example.gruppe2project2.model;


import jakarta.persistence.*;

@Entity
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    //int user_id;

    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "user_id", nullable = false)
    UserInfo user;

    @Column
    String itemName;

    @Column
    String wishlistName;

    public Wishlist(int id, UserInfo user, String itemName, String wishlistName) {
        this.id = id;
        this.user = user;
        this.itemName = itemName;
        this.wishlistName = wishlistName;
    }

    public Wishlist() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWishlistName() {
        return wishlistName;
    }
    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}

