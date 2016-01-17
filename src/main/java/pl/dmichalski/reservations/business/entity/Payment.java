package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Platnosc")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "idplatnosc")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idplatnoscmetoda")
    private PaymentMethod paymentMethod;

    @Column(name = "wartosc")
    private long value;

    @Column(name = "dataplatnosci")
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
