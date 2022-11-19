package com.mytechjourney.postgres.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customers", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "dob")
    Date dob;
    
    @Column(name = "address")
    String address;

    @Column(name = "mobile")
    Long mobileNumber;
}
