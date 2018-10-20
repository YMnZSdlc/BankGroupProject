package com.example.serverintro.entities;

import com.example.serverintro.enums.Sex;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Validated
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    private Integer salary;
    private Integer pesel;
    @Column(name = "employment_date")
    private Date employmentDate;
    private String email;
    @NotNull
    @Size(max = 9)
    @Column(name = "phone_no")
    private Integer phoneNo;
    private Sex sex;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}
