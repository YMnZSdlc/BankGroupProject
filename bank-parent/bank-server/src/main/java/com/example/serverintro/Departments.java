package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "dept_name")
    @NotNull
    private String deptName;
    @NotNull
    @Column(name = "dept_no")
    private Integer deptNo;
    @NotNull
    @Column(name = "dept_phone_no")
    private Integer deptPhoneNo;

    @OneToMany(mappedBy = "department")
    private List<Customer> customers;

    @OneToMany(mappedBy = "department")
    private List<Workers> workers;

}
