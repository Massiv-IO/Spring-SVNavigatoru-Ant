package inventorysystem.repository.impl;

import inventorysystem.domain.Product;
import inventorysystem.repository.ProductDao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateProductDao extends HibernateDaoSupport implements ProductDao {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> loadAll() {
		this.logger.info("Getting products!");
		return (List<Product>)this.getHibernateTemplate().loadAll(Product.class);
	}

	public void update(Product product) {
		this.logger.info("Updating product: " + product.getDescription() + ", new price " + product.getPrice());
		this.getHibernateTemplate().update(product);
	}
}
