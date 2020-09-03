package ke.co.seatec.fulltestspingboot.service;

import ke.co.seatec.fulltestspingboot.model.ProductModel;

import java.util.List;

/**
 * @author ASimiyu on 8/27/20 3:08 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.service
 */
public interface ProductService {
    /**
     * Delete product entity
     * @param productId
     */
    void deleteProduct(int productId);

    /**
     * Method to create a product with parameter Model
     *
     * @param productModel
     */
    ProductModel createProduct(ProductModel productModel);

    /**
     * Fetch All Products
     *
     */
    List<ProductModel> fetchProduct();

    /**
     * Update product entity
     *
     * @param productId
     * @param productModel
     */
    ProductModel updateProduct(int productId, ProductModel productModel);
}
