package inventorysystem.repository.impl;

import inventorysystem.domain.Product;
import inventorysystem.repository.ProductDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class ProductDaoImpl extends SimpleJdbcDaoSupport implements ProductDao {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> loadAll() {
		this.logger.info("Getting products!");
		List<Product> products = getSimpleJdbcTemplate().query(
				"SELECT id, description, price FROM products",
				new ProductMapper());
		return products;
	}

	public void update(Product product) {
		this.logger.info("Updating product: " + product.getDescription() + ", new price " + product.getPrice());
		
		int count = getSimpleJdbcTemplate()
				.update("UPDATE products SET description = :description, price = :price WHERE id = :id",
						new MapSqlParameterSource()
								.addValue("description", product.getDescription())
								.addValue("price", product.getPrice())
								.addValue("id", product.getId()));
		
		this.logger.info("Rows affected: " + count);
	}

	private static class ProductMapper implements
			ParameterizedRowMapper<Product> {
		
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(new Double(rs.getDouble("price")));
			return prod;
		}
	}
}
