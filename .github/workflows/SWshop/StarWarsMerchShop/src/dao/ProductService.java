package dao;
import java.util.List;
import javax.persistence.Persistence;

import model.Product;
public class ProductService {
	private ProductDao productdao;
	public ProductService() {
		try {
		 productdao = new ProductDao(Persistence.createEntityManagerFactory("ProiectFinalDataBase"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	

	public void updateProduct(Product updatedProduct) {
		productdao.update(updatedProduct);
	}

	public List<Product> getAllProducts() {
		return productdao.findAll();
	}

	
}
