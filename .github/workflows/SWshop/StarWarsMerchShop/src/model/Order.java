package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idorder;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;

	public Order() {
	}

	public int getIdorder() {
		return this.idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}