package ke.co.seatec.fulltestspingboot.serviceimpl;

import ke.co.seatec.fulltestspingboot.model.ProductModel;
import ke.co.seatec.fulltestspingboot.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ASimiyu on 8/27/20 3:11 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.serviceimpl
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final List<ProductModel> productsList = new ArrayList<>();

    @Override
    public void deleteProduct(int productId) {
        LOGGER.info("Deleting product...{}", productId);
        productsList.remove(productId);
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        int size = productsList.size() + 1;
        ProductModel si = new ProductModel();
        si.setProductDesc(productModel.getProductDesc());
        si.setProductName(productModel.getProductName());
        si.setProductId(size);
        productsList.add(si);
        return si;
    }

    @Override
    public List<ProductModel> fetchProduct() {
        LOGGER.info("Fetching product....");
        return getProductsList();
    }

    @Override
    public ProductModel updateProduct(int productId, ProductModel productModel) {
        LOGGER.info("Updating product...{}, {}", productId, productModel);
        productsList.remove(productId);
        ProductModel si = new ProductModel();
        si.setProductDesc(productModel.getProductDesc());
        si.setProductName(productModel.getProductName());
        si.setProductId(productId);
        return si;
    }

    public List<ProductModel> getProductsList() {
        IntStream.range(0, 10).forEachOrdered(i -> {
            ProductModel si = new ProductModel();
            si.setProductDesc("Description" + i);
            si.setProductId(i);
            si.setProductName("Product" + i);
            productsList.add(si);
        });
        return productsList;

    }
}
