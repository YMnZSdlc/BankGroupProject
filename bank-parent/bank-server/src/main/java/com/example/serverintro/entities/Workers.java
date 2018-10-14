package com.example.serverintro.entities;


import com.example.serverintro.enums.Sex;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
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
    @Column(name = "create_date")
    private LocalDateTime createDate;
    private String email;
    @NotNull
    @Size(max = 9)
    private Integer phoneNo;
    private Sex sex;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;


}
