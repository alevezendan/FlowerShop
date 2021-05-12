package repository;

import entity.Flower;
import entity.FlowerShop;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

	public void deleteUser(User user){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.detach(user);
		em.getTransaction().commit();
		em.close();
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
		List<User> users = em.createQuery("SELECT u FROM User u where u.FlowerShop=flowershop ", User.class).
				setParameter("FlowerShop",flowerShop).getResultList();
		em.close();
		return users;
	}
	public void updateName(User user, String name){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE user u SET u.Name =:name WHERE u.idClass =:id")
				.setParameter("id", user.getId()).setParameter("name", name).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public void updateUsername(User user, String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE user u SET u.Username =:username WHERE u.idClass =:id")
				.setParameter("id", user.getId()).setParameter("username", username).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public void updateRole(User user, String role){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("UPDATE user u SET u.Role =:role WHERE u.idClass =:id")
				.setParameter("id", user.getId()).setParameter("role", role).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}


}
