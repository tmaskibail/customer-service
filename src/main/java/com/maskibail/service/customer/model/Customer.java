package com.maskibail.service.customer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers", schema = "test")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dob;
    private Date createDate;

    public Customer(String title, String firstName, String middleName, String lastName, Date dob, Date createDate) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.createDate = createDate;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
