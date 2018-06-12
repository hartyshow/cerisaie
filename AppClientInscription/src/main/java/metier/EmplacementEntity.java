package metier;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EmplacementEntity")
@Table(name = "emplacement", schema = "cerisaie", catalog = "")
public class EmplacementEntity implements Serializable {

    private int numempl;
    private int codetypee;
    private int surfaceEmpl;
    private int nbpersmaxempl;

    @Id
    @Column(name = "numempl")
    public int getNumempl() {
        return numempl;
    }

    public void setNumempl(int numempl) {
        this.numempl = numempl;
    }

    @Id
    @Column(name = "codetypee")
    public int getCodetypee() {
        return codetypee;
    }

    public void setCodetypee(int codetypee) {
        this.codetypee = codetypee;
    }

    @Basic
    @Column(name = "surfaceEmpl")
    public int getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(int surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    @Basic
    @Column(name = "nbpersmaxempl")
    public int getNbpersmaxempl() {
        return nbpersmaxempl;
    }

    public void setNbpersmaxempl(int nbpersmaxempl) {
        this.nbpersmaxempl = nbpersmaxempl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplacementEntity that = (EmplacementEntity) o;

        if (numempl != that.numempl) return false;
        if (codetypee != that.codetypee) return false;
        if (surfaceEmpl != that.surfaceEmpl) return false;
        if (nbpersmaxempl != that.nbpersmaxempl) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numempl;
        result = 31 * result + codetypee;
        result = 31 * result + surfaceEmpl;
        result = 31 * result + nbpersmaxempl;
        return result;
    }
}
