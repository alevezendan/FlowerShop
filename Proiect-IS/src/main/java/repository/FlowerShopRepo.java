package repository;

import entity.FlowerShop;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlowerShopRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceFlowerShop");

    public void insertNewFlowerShop(FlowerShop flowerShop) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(flowerShop);
        em.getTransaction().commit();
        em.close();
    }
}
