package com.example.serverintro;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Integer id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="pesel")
    private String pesel;
    @Column(name="createDate")
    private Date createDate;
    @Column(name="email")
    private String email;
    @Column(name="phone_no")
    private int phone_no;
    @Column(name="dateOfBirth")
    private Date date_of_birth;
    @Column(name="sex")
    private SexEnum sex;
    @ManyToOne

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public Date getDate_of_birth() { return date_of_birth; }

    public void setDate_of_Birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
