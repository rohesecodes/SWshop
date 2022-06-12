package dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.Product;

import javax.persistence.*;
public class ProductDao extends GenericDao<Product> {
	private EntityManagerFactory factory;
	public ProductDao(EntityManagerFactory factory) {
		super(Product.class);
		this.factory = factory;
	}
	public ProductDao(Class<Product> eClass) {
		super(eClass);
		// TODO Auto-generated constructor stub
	}

	public ProductDao(Class<Product> eClass, EntityManagerFactory factory) {
		super(eClass);
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
	 public List<Product> find(String name){
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> q = cb.createQuery(Product.class);
		
		Root<Product> c = q.from(Product.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Product> query = em.createQuery(q);
		query.setParameter(paramName, name);
		
		List<Product> results = query.getResultList();
		return results;
	}

}
