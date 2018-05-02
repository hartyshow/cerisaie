package service;

import meserreurs.MonException;
import javax.persistence.*;
import metier.InscriptionEntity;

public class EnregistreInscription {

  // on décvlare un EntityManager
    private EntityManagerFactory factory;
    private  EntityManager entityManager;

    public  void insertionInscription(InscriptionEntity uneI) throws Exception, MonException {

       // On instancie l'entity Manager
        factory = Persistence.createEntityManagerFactory("PInscription");
        entityManager  = factory.createEntityManager();

        try {

            if (!entityManager.contains(uneI))
            {
                // On démarre une transaction
                entityManager.getTransaction().begin();
                entityManager.persist(uneI);
                entityManager.flush();
                // on valide la transacition
                entityManager.getTransaction().commit();
            }
            entityManager.close();

        } catch (EntityNotFoundException h) {
            new MonException("Erreur d'insertion", h.getMessage());
        } catch (Exception e) {
            new MonException("Erreur d'insertion", e.getMessage());
        }
    }
}

