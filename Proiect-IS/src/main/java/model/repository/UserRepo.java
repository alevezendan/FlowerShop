package model.repository;


import model.entity.FlowerShop;
import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceFlowerShop");

	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public List<User> logIn(String username) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> result = em.createQuery("from User", User.class).getResultList();
		em.getTransaction().commit();

		return result;
	}

	//public void deleteUser(User user){
	public void deleteUser(String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM User u WHERE u.username = :username ");
		((Query) query).setParameter("username", username);
		int rowsDeleted = query.executeUpdate();
		System.out.println("entities deleted: " + rowsDeleted);
		em.getTransaction().commit();
		em.close();
		/*em.remove(user);
		em.detach(user);

		em.getTransaction().commit();
		em.close();*/
	}

	public List<User> showAllUsers() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("from User", User.class).getResultList();
		em.close();
		return users;
	}

	public List<User> showUsersByFlowerShop(FlowerShop flowerShop) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		/*List<User> users = em.createQuery("SELECT u FROM User u where u.FlowerShop=flowershop ", User.class).
				setParameter("FlowerShop",flowerShop).getResultList();*/
		System.out.println(flowerShop);
		List<User> users=em.createQuery("from User u WHERE u.FlowerShop=:flowershop",User.class).getResultList();
		em.close();
		return users;
	}
	public void updateName(User user, String name){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE User u SET u.name =:name WHERE u.id =:id")
				.setParameter("id", user.getId()).setParameter("name", name).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public void updateUsername(User user, String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE User u SET u.username =:username WHERE u.id =:id")
				.setParameter("id", user.getId()).setParameter("username", username).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public void updateRole(User user, String role){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE User u SET u.role =:role WHERE u.id =:id")
				.setParameter("id", user.getId()).setParameter("role", role).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}


    public void updateLanguage(User user,String language) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE User u SET u.language =:language WHERE u.id =:id")
				.setParameter("id", user.getId()).setParameter("language", language).executeUpdate();
		em.getTransaction().commit();
		em.close();
    }
}
