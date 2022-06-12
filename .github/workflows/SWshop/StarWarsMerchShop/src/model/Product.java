package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproduct;

	private String brand;

	private String name;

	private double price;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="product")
	private List<Order> orders;

	public Product() {
	}

	public int getIdproduct() {
		return this.idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setProduct(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setProduct(null);

		return order;
	}

}