package inventorysystem.repository;

import inventorysystem.domain.Product;

import java.util.List;

public interface ProductDao {
	
	/**
	 * Returns all persistent instances of class Product.
	 */
	public List<Product> loadAll();

	/**
	 * Updates the given persistent instance of Product.
	 */
	public void update(Product product);
}
