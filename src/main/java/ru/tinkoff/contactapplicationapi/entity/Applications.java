package ru.tinkoff.contactapplicationapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPLICATIONS")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID", nullable = true)
    private Contact contact;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DT_CREATED")
    private Date dtCreated;

    public Applications() {
    }

    public Applications(Contact contact, String productName, Date dtCreated) {
        this.contact = contact;
        this.productName = productName;
        this.dtCreated = dtCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }
}