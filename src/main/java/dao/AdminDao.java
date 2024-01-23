package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Admin;

public class AdminDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("amit").createEntityManager();
	}
	
	public Admin saveAdmin(Admin admin) {
		
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("select a from Admin a where a.email=?1");
		query.setParameter(1, admin.getEmail());
				
		try {
			query.getSingleResult();
		} catch (NoResultException e) {
			em.getTransaction().begin();
			em.persist(admin);
			em.getTransaction().commit();
			
			return admin;
		}
		return null;
	}
	
	public Admin findByEmail(String email) {
		
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("select a from Admin a where a.email=?1");
		query.setParameter(1, email);
		
		Admin admin = null;
		
		try {
			admin = (Admin) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return admin;
	}
}
