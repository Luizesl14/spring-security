package com.spring.secirity.infrastructure.model;


import com.spring.secirity.infrastructure.util.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "credi_person")
public class Person extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "email")
    private String email;

    @NumberFormat(pattern = "##.#####-####")
    @Column(name = "phone")
    private String phone;


}
