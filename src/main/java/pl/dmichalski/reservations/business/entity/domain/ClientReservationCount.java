package pl.dmichalski.reservations.business.entity.domain;

public class ClientReservationCount {

    private String name;
    private String email;
    private long count;

    public ClientReservationCount(String name, String email, long count) {
        this.name = name;
        this.email = email;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
