package metier;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "inscription", schema = "lesinscriptions", catalog = "")
public class InscriptionEntity {
    private int numcandidat;
    private String nomcandidat;
    private String prenomcandidat;
    private Date datenaissance;
    private String adresse;
    private String cpostal;
    private String ville;

    // Auto incrémlent pour Mysql
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getNumcandidat() {
        return numcandidat;
    }

    public void setNumcandidat(int numcandidat) {
        this.numcandidat = numcandidat;
    }

    @Basic
    @Column(name = "nomcandidat")
    public String getNomcandidat() {
        return nomcandidat;
    }

    public void setNomcandidat(String nomcandidat) {
        this.nomcandidat = nomcandidat;
    }

    @Basic
    @Column(name = "prenomcandidat")
    public String getPrenomcandidat() {
        return prenomcandidat;
    }

    public void setPrenomcandidat(String prenomcandidat) {
        this.prenomcandidat = prenomcandidat;
    }

    @Basic
    @Column(name = "datenaissance")
    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "cpostal")
    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntity that = (InscriptionEntity) o;

        if (numcandidat != that.numcandidat) return false;
        if (nomcandidat != null ? !nomcandidat.equals(that.nomcandidat) : that.nomcandidat != null) return false;
        if (prenomcandidat != null ? !prenomcandidat.equals(that.prenomcandidat) : that.prenomcandidat != null)
            return false;
        if (datenaissance != null ? !datenaissance.equals(that.datenaissance) : that.datenaissance != null)
            return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (cpostal != null ? !cpostal.equals(that.cpostal) : that.cpostal != null) return false;
        if (ville != null ? !ville.equals(that.ville) : that.ville != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numcandidat;
        result = 31 * result + (nomcandidat != null ? nomcandidat.hashCode() : 0);
        result = 31 * result + (prenomcandidat != null ? prenomcandidat.hashCode() : 0);
        result = 31 * result + (datenaissance != null ? datenaissance.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        return result;
    }
}
