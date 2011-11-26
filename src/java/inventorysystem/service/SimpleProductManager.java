package inventorysystem.service;

import inventorysystem.domain.Product;
import inventorysystem.repository.ProductDao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2155845235094494378L;
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> getProducts() {
		return this.productDao.loadAll();
	}

	public void increasePrice(int percentage) {
		List<Product> products = this.getProducts();
		if (products == null) {
			return;
		}

		double newCoefficient = ((double)(100 + percentage)) / 100;
		this.logger.info("New increase coefficient: " + newCoefficient);
		
		for (Product product : products) {
			product.setPrice(product.getPrice() * newCoefficient);
			this.productDao.update(product);
		}
	}
}
