package ke.co.seatec.fulltestspingboot.controller;

import ke.co.seatec.fulltestspingboot.events.ProductEvent;
import ke.co.seatec.fulltestspingboot.model.ProductModel;
import ke.co.seatec.fulltestspingboot.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.kv;

/**
 * @author ASimiyu on 8/27/20
 * @project fulltestspingboot
 */
@RestController
@RequestMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {
 private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private JmsTemplate jmsTemplate;
    private String updateProducts;

    @GetMapping(value = "/get-hello", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getWelcome() {
        return "Hello world..";
    }

    @GetMapping(value = "/get-all-products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProducts() {
        List<ProductModel> products = productService.fetchProduct();
        LOGGER.info("Fetching all Products {}",kv("Products",products));
        jmsTemplate.convertAndSend("inbound.topic", products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "/create-product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody ProductModel productModel) {
        ProductModel product = productService.createProduct(productModel);
        LOGGER.info("Publishing creation of  product ->");
        applicationEventPublisher.publishEvent(new ProductEvent(this,product));
        jmsTemplate.convertAndSend("CreateProducts", product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/update-product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestParam int productId, @RequestBody ProductModel productModel) {
        ProductModel product = productService.updateProduct(productId, productModel);
        jmsTemplate.convertAndSend(updateProducts, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/delete-product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable(value = "productId") int productId) {
        productService.deleteProduct(productId);
        jmsTemplate.convertAndSend("DeleteProduct",productId);
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    @JmsListener(destination = "inbound.topic")
    public void topic(List<ProductModel> message) {
        LOGGER.info("Listeners(From Controller)--- received {}", message);
    }
}
