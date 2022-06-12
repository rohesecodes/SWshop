package dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.Order;

import javax.persistence.*;
public class OrderDao extends GenericDao<Order> {
	private EntityManagerFactory factory;
	public OrderDao(EntityManagerFactory factory) {
		super(Order.class);
		this.factory = factory;
	}
	public OrderDao(Class<Order> eClass) {
		super(eClass);
		// TODO Auto-generated constructor stub
	}

	public OrderDao(Class<Order> eClass, EntityManagerFactory factory) {
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
	 public List<Order> find(String name){
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> q = cb.createQuery(Order.class);
		
		Root<Order> c = q.from(Order.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("name"), paramName));
		TypedQuery<Order> query = em.createQuery(q);
		query.setParameter(paramName, name);
		
		List<Order> results = query.getResultList();
		return results;
	}
}
