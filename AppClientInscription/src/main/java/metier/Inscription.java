
package metier;


import java.io.Serializable;
import java.sql.Date;


public class Inscription implements Serializable {
    private int numcandidat;
    private String nomcandidat;
    private String prenomcandidat;
    private Date datenaissance;
    private String adresse;
    private String cpostal;
    private String ville;


    public int getNumcandidat() {
        return numcandidat;
    }

    public void setNumcandidat(int numcandidat) {
        this.numcandidat = numcandidat;
    }

    public String getNomcandidat() {
        return nomcandidat;
    }

    public void setNomcandidat(String nomcandidat) {
        this.nomcandidat = nomcandidat;
    }


    public String getPrenomcandidat() {
        return prenomcandidat;
    }

    public void setPrenomcandidat(String prenomcandidat) {
        this.prenomcandidat = prenomcandidat;
    }


    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }


    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


}
