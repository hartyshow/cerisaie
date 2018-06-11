package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "ActiviteEntity")
@Table(name = "Activite", schema = "cerisaie", catalog = "")
public class ActiviteEntity implements Serializable {

    private int codesport;
    private Date datejour;
    private int numsej;
    private int nbloc;

    @Id
    @Column(name = "codesport")
    public int getCodesport() {
        return codesport;
    }

    public void setCodesport(int codesport) {
        this.codesport = codesport;
    }

    @Id
    @Column(name = "datejour")
    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Id
    @Column(name = "numsej")
    public int getNumsej() {
        return numsej;
    }

    public void setNumsej(int numsej) {
        this.numsej = numsej;
    }

    @Basic
    @Column(name = "nbloc")
    public int getNbloc() {
        return nbloc;
    }

    public void setNbloc(int nbloc) {
        this.nbloc = nbloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiviteEntity that = (ActiviteEntity) o;

        if (codesport != that.codesport) return false;
        if (datejour != null ? !datejour.equals(that.datejour) : that.datejour != null) return false;
        if (numsej != that.numsej) return false;
        if (nbloc != that.nbloc) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codesport;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        result = 31 * result + numsej;
        result = 31 * result + nbloc;
        return result;
    }

    @Override
    public String toString() {
        return "codesport : " + codesport + " / datejour : " + datejour + " / numsej : " + numsej + " / nbloc : " + nbloc;
    }
}
