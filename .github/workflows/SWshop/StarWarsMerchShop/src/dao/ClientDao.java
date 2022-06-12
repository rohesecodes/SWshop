package dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Client;

import javax.persistence.*;
public class ClientDao extends GenericDao<Client> {
	public ClientDao(Class<Client> eClass) {
		super(eClass);
		// TODO Auto-generated constructor stub
	}

	private EntityManagerFactory factory;
	public ClientDao(EntityManagerFactory factory) {
		super(Client.class);
		this.factory = factory;
	}




	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		try {
			return factory.createEntityManager();
		}catch(Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}
	 public List<Client> find(String name){
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Client> q = cb.createQuery(Client.class);
		
		Root<Client> c = q.from(Client.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Client> query = em.createQuery(q);
		query.setParameter(paramName, name);
		
		List<Client> results = query.getResultList();
		return results;
	}

	public void create(Client newClient) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(newClient);
			entityManager.getTransaction().commit();
			
		}catch(Exception ex) {
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
	}
		
}
