package metier;

import java.io.Serializable;
import java.sql.Date;

public class Sejour implements Serializable {
    private int numsej;
    private int numcli;
    private int numempl;
    private Date datedebSej;
    private Date datefinSej;
    private int nbpersonnes;

    public int getNumsej() {
        return numsej;
    }

    public void setNumsej(int numsej) {
        this.numsej = numsej;
    }

    public int getNumcli() {
        return numcli;
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }

    public int getNumempl() {
        return numempl;
    }

    public void setNumempl(int numempl) {
        this.numempl = numempl;
    }

    public Date getDatedebSej() {
        return datedebSej;
    }

    public void setDatedebSej(Date datedebSej) {
        this.datedebSej = datedebSej;
    }

    public Date getDatefinSej() {
        return datefinSej;
    }

    public void setDatefinSej(Date datefinSej) {
        this.datefinSej = datefinSej;
    }

    public int getNbpersonnes() {
        return nbpersonnes;
    }

    public void setNbpersonnes(int nbpersonnes) {
        this.nbpersonnes = nbpersonnes;
    }
}
