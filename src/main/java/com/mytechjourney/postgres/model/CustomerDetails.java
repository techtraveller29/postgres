package com.mytechjourney.postgres.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CustomerDetails {
    String name;
    Date dob;
    String address;
    Long mobileNumber;
}
