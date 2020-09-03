package ke.co.seatec.fulltestspingboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ASimiyu on 8/27/20 3:19 PM
 * project -> fulltestspingboot
 * package -> ke.co.seatec.fulltestspingboot.model
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ProductModel implements Serializable {
    private int productId;
    private String productName;
    private String productDesc;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
