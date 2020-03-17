package com.learn.hibernate.manytomany.example10;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Integer cid;
    private String           cartName;
    /*
     * since already mappedby used in Item class,
     * here only we need to add the @jointable configurations to create table with otherthan default names
     */
    @ManyToMany
    @JoinTable(name = "CART_ITEM", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Collection<Item> items = new ArrayList();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

}
