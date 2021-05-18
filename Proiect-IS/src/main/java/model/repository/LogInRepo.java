package model.repository;



import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LogInRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceFlowerShop");

    public User logIn(String username, String password) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.createQuery("SELECT s FROM user s where s.Username =: username", User.class)
                .setParameter("username",username )
                .getSingleResult();
        em.close();
        return user;
    }
}
