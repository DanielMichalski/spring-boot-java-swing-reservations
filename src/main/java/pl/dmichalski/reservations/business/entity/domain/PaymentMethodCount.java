package pl.dmichalski.reservations.business.entity.domain;

public class PaymentMethodCount {

    private String name;
    private long count;

    public PaymentMethodCount(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
