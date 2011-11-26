package inventorysystem.web;

import inventorysystem.service.PriceIncrease;
import inventorysystem.service.ProductManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

public class PriceIncreaseFormController extends SimpleFormController {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ProductManager productManager;
	
	private final int DEFAULT_PERCENTAGE = 20;

	public ModelAndView onSubmit(Object command) throws ServletException {
		int increase = ((PriceIncrease) command).getPercentage();
		this.logger.info("Increasing prices by " + increase + "%.");
		
		this.productManager.increasePrice(increase);
		
		this.logger.info("returning from PriceIncreaseForm view to "
				+ this.getSuccessView());
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(this.DEFAULT_PERCENTAGE);
		return priceIncrease;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return this.productManager;
	}
}
