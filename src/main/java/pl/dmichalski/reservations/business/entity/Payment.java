package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id_payment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "value")
    private long value;

    @Column(name = "date_of_payment")
    private Date dateOfPayments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Date getDateOfPayments() {
        return dateOfPayments;
    }

    public void setDateOfPayments(Date dateOfPayments) {
        this.dateOfPayments = dateOfPayments;
    }

    @Override
    public String toString() {
        return paymentMethod + "";
    }
}
