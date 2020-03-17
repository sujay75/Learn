package com.learn.hibernate.manytomany.example10;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer itemId;

    private String  itemName;

    @ManyToMany(mappedBy = "items")
    private Collection<Cart> carts = new ArrayList();

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Collection<Cart> getCart() {
        return carts;
    }

    public void setCart(Collection<Cart> cart) {
        this.carts = cart;
    }
}
