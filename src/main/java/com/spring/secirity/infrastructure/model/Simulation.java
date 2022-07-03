package com.spring.secirity.infrastructure.model;


import com.spring.secirity.infrastructure.util.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Setter
@Entity
@Table(name = "credi_simulation")
public class Simulation extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="person_id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id")
    private User user;

    @Column(name = "grace")
    private Integer grace;

    @NumberFormat(pattern = "######.##")
    private BigDecimal amount;

    @Column(name = "monthly_icome")
    @NumberFormat(pattern = "######.##")
    private BigDecimal monthlyIcome;
}
