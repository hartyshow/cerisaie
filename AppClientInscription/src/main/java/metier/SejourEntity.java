package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "SejourEntity")
@Table(name = "sejour", schema = "cerisaie", catalog = "")
public class SejourEntity implements Serializable {
    private int numsej;
    private int numcli;
    private int numempl;
    private Date datedebSej;
    private Date datefinSej;
    private int nbpersonnes;

    @Id
    @Column(name = "numsej")
    public int getNumsej() {
        return numsej;
    }

    public void setNumsej(int numsej) {
        this.numsej = numsej;
    }

    @Column(name = "numcli")
    public int getNumcli() {
        return numcli;
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }

    @Column(name = "numempl")
    public int getNumempl() {
        return numempl;
    }

    public void setNumempl(int numempl) {
        this.numempl = numempl;
    }

    @Column(name = "datedebsej")
    public Date getDatedebSej() {
        return datedebSej;
    }

    public void setDatedebSej(Date datedebSej) {
        this.datedebSej = datedebSej;
    }

    @Column(name = "datefinsej")
    public Date getDatefinSej() {
        return datefinSej;
    }

    public void setDatefinSej(Date datefinSej) {
        this.datefinSej = datefinSej;
    }

    @Column(name = "nbpersonnes")
    public int getNbpersonnes() {
        return nbpersonnes;
    }

    public void setNbpersonnes(int nbpersonnes) {
        this.nbpersonnes = nbpersonnes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SejourEntity that = (SejourEntity) o;

        if (numempl != that.numempl) return false;
        if (numcli != that.numcli) return false;
        if (numempl != that.numempl) return false;
        if (datedebSej != null ? !datedebSej.equals(that.datedebSej) : that.datedebSej != null) return false;
        if (datefinSej != null ? !datefinSej.equals(that.datefinSej) : that.datefinSej != null) return false;
        if (nbpersonnes != that.nbpersonnes) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numempl;
        result = 31 * result + numcli;
        result = 31 * result + numempl;
        result = 31 * result + (datedebSej != null ? datedebSej.hashCode() : 0);
        result = 31 * result + (datefinSej != null ? datefinSej.hashCode() : 0);
        result = 31 * result + nbpersonnes;
        return result;
    }
}
