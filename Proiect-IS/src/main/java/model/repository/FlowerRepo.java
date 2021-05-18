package model.repository;



import model.entity.Flower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class FlowerRepo {

    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("persistenceFlowerShop");

    public void insertFlower(Flower flower){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(flower);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteFlower(Flower flower,int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Flower f WHERE f.id = :id ");
        ((Query) query).setParameter("id", id);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        em.getTransaction().commit();
        em.close();
    }


    public List<Flower> showAllFlowers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("from Flower", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> searchByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.name =: name", Flower.class).setParameter("name",name)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.name =: name", Flower.class).setParameter("name",name)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByPrice(Double price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.price =: price", Flower.class).setParameter("price",price)
                .getResultList();
        em.close();
        return flowers;
    }
    public List<Flower> filterByColor(String color) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.color =: color", Flower.class).setParameter("color",color)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByAvailability(String availability) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.availability =: availability", Flower.class).setParameter("availability",availability)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByQuantity(Double quantity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flower f WHERE f.quantity =: quantity", Flower.class).setParameter("quantity",quantity)
                .getResultList();
        em.close();
        return flowers;
    }

    public void updateName(Flower flower, String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Flower u SET u.name =:name WHERE u.id =:id")
                .setParameter("id", flower.getId()).setParameter("name", name).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateColor(Flower flower, String color){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Flower u SET u.color =:color WHERE u.id =:id")
                .setParameter("id", flower.getId()).setParameter("color", color).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateAvailability(Flower flower, String availability){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Flower u SET u.availability =:availability WHERE u.id =:id")
                .setParameter("id", flower.getId()).setParameter("availability", availability).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updatePrice(Flower flower, double price){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Flower u SET u.price =:price WHERE u.id =:id")
                .setParameter("id", flower.getId()).setParameter("price", price).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateQuantity(Flower flower, double quantity){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE Flower u SET u.quantity =:quantity WHERE u.id =:id")
                .setParameter("id", flower.getId()).setParameter("quantity",quantity).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
