package repository;

import entity.Flower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public void deleteFlower(Flower flower){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.detach(flower);
        em.getTransaction().commit();
        em.close();
    }

    public void updateName(Flower flower, String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE flowers f SET f.Name =:name WHERE f.idClass =:id")
                .setParameter("id", flower.getId()).setParameter("name", name).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updatePrice(Flower flower, Double price){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE flowers f SET f.Price =:price WHERE f.idClass =:id")
                .setParameter("id", flower.getId()).setParameter("price", price).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateColor(Flower flower, String color){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE flowers f SET f.Color =:color WHERE f.idClass =:id")
                .setParameter("id", flower.getId()).setParameter("color", color).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateAvailabillity(Flower flower, String avail){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE flowers f SET f.Availability =:avail WHERE f.idClass =:id")
                .setParameter("id", flower.getId()).setParameter("availability", avail).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateQuantity(Flower flower, Double quant){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("UPDATE flowers f SET f.Quantity=:quant WHERE f.idClass =:id")
                .setParameter("id", flower.getId()).setParameter("quantity", quant).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public List<Flower> showAllFlowers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f ", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> searchByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Name := name", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Name := name", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByPrice(Double price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Price := price", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }
    public List<Flower> filterByColor(String color) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Color := color", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByAvailability(String avail) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Availability := avail", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

    public List<Flower> filterByQuantity(Double quant) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flower> flowers = em.createQuery("SELECT f FROM Flowers f WHERE f.Quantity := quant", Flower.class)
                .getResultList();
        em.close();
        return flowers;
    }

}
