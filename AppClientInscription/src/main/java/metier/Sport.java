package metier;

import java.io.Serializable;

public class Sport implements Serializable {

    private int codesport;
    private String libellesport;
    private String unitetpssport;
    private int tarifunite;

    public int getCodesport() {
        return codesport;
    }

    public void setCodesport(int codesport) {
        this.codesport = codesport;
    }

    public String getLibellesport() {
        return libellesport;
    }

    public void setLibellesport(String libellesport) {
        this.libellesport = libellesport;
    }

    public String getUnitetpssport() {
        return unitetpssport;
    }

    public void setUnitetpssport(String unitetpssport) {
        this.unitetpssport = unitetpssport;
    }

    public int getTarifunite() {
        return tarifunite;
    }

    public void setTarifunite(int tarifunite) {
        this.tarifunite = tarifunite;
    }

}
