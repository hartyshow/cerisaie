package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class EntityService {

    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() throws Exception
    {
        emf = Persistence.createEntityManagerFactory("PInscription");
        entitymanager = emf.createEntityManager();

        return entitymanager.getTransaction();
    }

}
