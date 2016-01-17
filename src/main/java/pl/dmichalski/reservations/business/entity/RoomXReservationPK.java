package pl.dmichalski.reservations.business.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RoomXReservationPK implements Serializable {

   /* @Column(name = "idrezerwacja")
    @Id
    private Serializable idrezerwacja;

    @Column(name = "idpokoj")
    @Id
    private Serializable idpokoj;


    public Serializable getIdrezerwacja() {
        return idrezerwacja;
    }

    public void setIdrezerwacja(Serializable idrezerwacja) {
        this.idrezerwacja = idrezerwacja;
    }


    public Serializable getIdpokoj() {
        return idpokoj;
    }

    public void setIdpokoj(Serializable idpokoj) {
        this.idpokoj = idpokoj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomXReservationPK that = (RoomXReservationPK) o;

        if (idrezerwacja != null ? !idrezerwacja.equals(that.idrezerwacja) : that.idrezerwacja != null) return false;
        if (idpokoj != null ? !idpokoj.equals(that.idpokoj) : that.idpokoj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrezerwacja != null ? idrezerwacja.hashCode() : 0;
        result = 31 * result + (idpokoj != null ? idpokoj.hashCode() : 0);
        return result;
    }*/
}
