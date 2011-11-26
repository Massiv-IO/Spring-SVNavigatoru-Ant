package inventorysystem.service;

import java.io.Serializable;
import java.util.List;

import inventorysystem.domain.Product;
import inventorysystem.repository.ProductDao;

public interface ProductManager extends Serializable {
	
	public void setProductDao(ProductDao productDao);
	
	public List<Product> getProducts();
	
	public void increasePrice(int percentage);
}
