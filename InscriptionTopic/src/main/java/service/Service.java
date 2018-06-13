package service;

import meserreurs.MonException;
import javax.persistence.*;
import metier.ActiviteEntity;
import java.util.Date;

public class Service extends EntityService{
    public void insertionActivite(ActiviteEntity uneActivite) throws Exception, MonException {
        EntityTransaction transac = startTransaction();
        try {
            if (!entitymanager.contains(uneActivite))
            {
                // On démarre une transaction
                transac.begin();
                entitymanager.persist(uneActivite);
                // on valide la transacition
                transac.commit();
            }
            entitymanager.close();

        } catch (EntityNotFoundException h) {
            new MonException("Erreur d'insertion", h.getMessage());
        } catch (Exception e) {
            new MonException("Erreur d'insertion", e.getMessage());
        }
    }

    public void updateActivite(ActiviteEntity uneActivite, int nbBlocToAdd) throws Exception{
        EntityTransaction transac = startTransaction();
        try {
            // On démarre une transaction
            transac.begin();
            entitymanager.createQuery("UPDATE ActiviteEntity a SET a.nbloc = :nbbloc WHERE a.codesport = :codeSport " +
                    "AND a.datejour = :datedebut AND a.numsej = :numSej").setParameter("codeSport", uneActivite.getCodesport())
                    .setParameter("datedebut", uneActivite.getDatejour()).setParameter("numSej", uneActivite.getNumsej())
                    .setParameter("nbbloc", uneActivite.getNbloc() + nbBlocToAdd).executeUpdate();
            // on valide la transacition
            transac.commit();
            entitymanager.close();
        } catch (EntityNotFoundException h) {
            new MonException("Erreur de mise à jour", h.getMessage());
        } catch (Exception e) {
            new MonException("Erreur de mise à jour", e.getMessage());
        }
    }

    public ActiviteEntity getActiviteIfExist(int numSej, int codeSport, Date datedebut) throws MonException {
        ActiviteEntity activite = null;
        try {
            EntityTransaction transac = startTransaction();
            transac.begin();
            activite = (ActiviteEntity) entitymanager.createQuery("SELECT a FROM ActiviteEntity a WHERE a.codesport = :codeSport " +
                    "AND a.datejour = :datedebut AND a.numsej = :numSej").setParameter("codeSport", codeSport)
                    .setParameter("datedebut", datedebut).setParameter("numSej", numSej).getSingleResult();
            entitymanager.close();
        } catch (RuntimeException e) {
            new MonException("Erreur de lecture", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activite;
    }
}

