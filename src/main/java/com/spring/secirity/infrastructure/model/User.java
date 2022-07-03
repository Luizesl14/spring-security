package com.spring.secirity.infrastructure.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.secirity.infrastructure.util.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "credi_user")
public class User extends BaseModel {

    @Column(name = "user_name")
    private String userName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
}
