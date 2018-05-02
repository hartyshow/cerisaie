
package metier;


import java.io.Serializable;
import java.sql.Date;


public class Activite implements Serializable {
    private int codesport;
    private Date datejour;
    private int numsejour;
    private int nbloc;

    public int getCodesport() {
        return codesport;
    }

    public void setCodesport(int codesport) {
        this.codesport = codesport;
    }

    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    public int getNumsejour() {
        return numsejour;
    }

    public void setNumsejour(int numsejour) {
        this.numsejour = numsejour;
    }

    public int getNbloc() {
        return nbloc;
    }

    public void setNbloc(int nbloc) {
        this.nbloc = nbloc;
    }
}
