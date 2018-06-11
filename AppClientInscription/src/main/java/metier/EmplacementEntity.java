package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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

}
