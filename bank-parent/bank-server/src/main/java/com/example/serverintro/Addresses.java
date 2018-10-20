package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Addresses {

    @Id
    private Integer id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_no")
    private String streetNo;
    @Column(name = "home_no")
    private String homeNo;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;

}
