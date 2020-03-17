package com.learn.hibernate.manytoone.mappedby.example9;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Custom {

    @Id
    @GeneratedValue
    @Column(name = "custom_id")
    private Integer cid;
    private String  name;


    @OneToMany(mappedBy = "customerDetails")
    // here JoinTable is optional, for new table which has id's of both the table which represent the one to many relation,
    // table rename or column rename can be changed
    // @JoinTable(name = "CUSTOMER_PRODUCT", joinColumns = @JoinColumn(name = "FK_CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name = "FK_PRODUCT_ID"))
    private Collection<Prodct> product = new ArrayList();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Prodct> getProduct() {
        return product;
    }

    public void setProduct(Collection<Prodct> product) {
        this.product = product;
    }

}
