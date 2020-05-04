package com.anhvv.hibernate.example.inheritance;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "payment")
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long amount;

    @OneToMany(mappedBy = "payment", orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    private List<PaymentDetailEntity> paymentDetails;

    public void addPaymentDetail(PaymentDetailEntity paymentDetail) {
        if(paymentDetails == null) {
            paymentDetails = new ArrayList<>();
        }
        paymentDetails.add(paymentDetail);
        paymentDetail.setPayment(this);
    }

    public void removePaymentDetail(PaymentDetailEntity paymentDetail) {
        if(paymentDetails != null) {
            paymentDetails.removeIf(x -> x.getId().equals(paymentDetail.getId()));
        }
    }
}
