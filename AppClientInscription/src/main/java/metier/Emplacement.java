
package metier;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


public class Emplacement implements Serializable {

    private int numempl;
    private int codetypee;
    private int surfaceEmpl;
    private int nbpersmaxempl;

    public int getNumempl() {
        return numempl;
    }

    public void setNumempl(int numempl) {
        this.numempl = numempl;
    }

    public int getCodetypee() {
        return codetypee;
    }

    public void setCodetypee(int codetypee) {
        this.codetypee = codetypee;
    }

    public int getSurfaceEmpl() {
        return surfaceEmpl;
    }

    public void setSurfaceEmpl(int surfaceEmpl) {
        this.surfaceEmpl = surfaceEmpl;
    }

    public int getNbpersmaxempl() {
        return nbpersmaxempl;
    }

    public void setNbpersmaxempl(int nbpersmaxempl) {
        this.nbpersmaxempl = nbpersmaxempl;
    }
}
