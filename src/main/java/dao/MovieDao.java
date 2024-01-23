package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Movie;

public class MovieDao {
	
	
	public EntityManager getentityManager() {
		return Persistence.createEntityManagerFactory("amit").createEntityManager();
	}
	
	public Movie saveMovie(Movie m) {
		EntityManager em = getentityManager();
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
		return m;
	}
	
	
	public List<Movie> getAllMovie() {
		
		EntityManager em = getentityManager();
		
		Query query = em.createQuery("select m from Movie m");
		
		return query.getResultList();
	}
	
	public Movie findByMovieId(int movieId) {
		
		Movie m = getentityManager().find(Movie.class, movieId);
		
		if(m != null)
			return m;
		
		return null;
	}
	
	public Movie updateMovie(Movie m) {
		
		EntityManager em = getentityManager();
		
		Movie exists = em.find(Movie.class, m.getId());
		
		if(exists != null) {
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
			
			return m;
		}
		return null;
	}
	
	public void removeMovie(int movieId) {
		
		EntityManager em = getentityManager();
		
		em.getTransaction().begin();
		em.remove(em.find(Movie.class, movieId));
		em.getTransaction().commit();
	}
}