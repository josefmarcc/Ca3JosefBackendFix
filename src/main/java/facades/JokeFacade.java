/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.SavedJokesDTO;
import entities.SavedJoke;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author josef
 */
public class JokeFacade {

    private static EntityManagerFactory emf;
    private static JokeFacade instance;

    public JokeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void saveJoke(String joke) {
        EntityManager em = emf.createEntityManager();
        SavedJoke sj = new SavedJoke(joke);

        try {
            em.getTransaction().begin();
            em.persist(sj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
     public SavedJokesDTO getAllSavedJokes() {
        EntityManager em = emf.createEntityManager(); 
        try {
            return new SavedJokesDTO(em.createQuery("SELECT j from SavedJoke j").getResultList());
        } finally {
            em.close();
        }
    }

}
