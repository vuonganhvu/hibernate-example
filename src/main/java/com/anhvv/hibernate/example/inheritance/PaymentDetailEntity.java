package com.anhvv.hibernate.example.inheritance;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "PAYMENT")
@Data
@Where( clause = "type = 'PAYMENT'" )
public class PaymentDetailEntity extends ActionDetailEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
    private PaymentEntity payment;

}
