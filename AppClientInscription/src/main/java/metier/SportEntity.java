package metier;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "SportEntity")
@Table(name = "Sport", schema = "cerisaie", catalog = "")
public class SportEntity implements Serializable {

    private int codesport;
    private String libellesport;
    private String unitetpssport;
    private int tarifunite;

    @Id
    @Column(name = "CodeSport")
    public int getCodesport() {
        return codesport;
    }

    public void setCodesport(int codesport) {
        this.codesport = codesport;
    }

    @Basic
    @Column(name = "LibelleSport")
    public String getLibellesport() {
        return libellesport;
    }

    public void setLibellesport(String libellesport) {
        this.libellesport = libellesport;
    }

    @Basic
    @Column(name = "UniteTpsSport")
    public String getUnitetpssport() {
        return unitetpssport;
    }

    public void setUnitetpssport(String unitetpssport) {
        this.unitetpssport = unitetpssport;
    }

    @Basic
    @Column(name = "TarifUnite")
    public int getTarifunite() {
        return tarifunite;
    }

    public void setTarifunite(int tarifunite) {
        this.tarifunite = tarifunite;
    }

    @Override
    public String toString() {
        return "codesport : " + codesport + " / libellesport : " + libellesport + " / unitetpssport : " + unitetpssport + " / tarifunite : " + tarifunite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEntity that = (SportEntity) o;

        if (codesport != that.codesport) return false;
        if (libellesport != that.libellesport) return false;
        if (unitetpssport != that.unitetpssport) return false;
        if (tarifunite != that.tarifunite) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codesport;
        result = 31 * result + libellesport.hashCode();
        result = 31 * result + unitetpssport.hashCode();
        result = 31 * result + tarifunite;
        return result;
    }
}
