package ke.co.seatec.fulltestspingboot.events;

import ke.co.seatec.fulltestspingboot.model.ProductModel;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author Your name on 9/3/20 8:24 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.events
 */
public class ProductEvent extends ApplicationEvent implements Serializable {

    private ProductModel productModel;

    public ProductEvent(Object source, ProductModel productModel) {
        super(source);
        this.productModel = productModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }
}
