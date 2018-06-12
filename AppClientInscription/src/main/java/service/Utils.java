package service;

import meserreurs.MonException;
import metier.Activite;
import metier.Emplacement;
import metier.Sejour;
import metier.Sport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Utils {

  // on déclare un EntityManager
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public List<Sport> getSports() {
        factory = Persistence.createEntityManagerFactory("PInscription");
        entityManager  = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Sport> sports = entityManager.createQuery("SELECT s FROM SportEntity s").getResultList();
            entityManager.close();

            return sports;
        }
        catch (Exception e) {
            new MonException("Erreur de sélection des sports", e.getMessage());

            return null;
        }
    }

    public List<Emplacement> getEmplacements() {
        factory = Persistence.createEntityManagerFactory("PInscription");
        entityManager  = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Emplacement> emplacements = entityManager.createQuery("SELECT s FROM EmplacementEntity s").getResultList();
            entityManager.close();

            return emplacements;
        } catch (Exception e) {
            new MonException("Erreur de sélection des emplacements", e.getMessage());

            return null;
        }
    }

    public List<Sejour> getSejours() {
        factory = Persistence.createEntityManagerFactory("PInscription");
        entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Sejour> sejours = entityManager.createQuery("SELECT s FROM SejourEntity s").getResultList();
            entityManager.close();

            return sejours;
        } catch (Exception e) {
            new MonException("Erreur de sélection des emplacements", e.getMessage());

            return null;
        }
    }

    public List<Activite> getActivites() {
        factory = Persistence.createEntityManagerFactory("PInscription");
        entityManager  = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Activite> activites = entityManager.createQuery("SELECT a FROM ActiviteEntity a").getResultList();
            entityManager.close();

            return activites;
        }
        catch (Exception e) {
            new MonException("Erreur de sélection des activités", e.getMessage());

            return null;
        }
    }
}

