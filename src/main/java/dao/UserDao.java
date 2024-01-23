package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("amit").createEntityManager();
	}
	
	public User saveUser(User user) {
		
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, user.getEmail());
		
		try {
			query.getSingleResult();
		} catch (NoResultException e) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			
			return user;
		}
		return null;
	}
	
	public User findByEmail(String email) {
		
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		
		User user = null;
		
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return user;
	}
}
