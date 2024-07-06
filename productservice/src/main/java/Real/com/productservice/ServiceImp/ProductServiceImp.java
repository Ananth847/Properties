package Real.com.productservice.ServiceImp;

import Real.com.productservice.Entity.Product;
import Real.com.productservice.Exception.ProductException;
import Real.com.productservice.Model.ProductRequest;
import Real.com.productservice.Model.ProductResponse;

public interface ProductServiceImp {
    public Product saveProduct(ProductRequest productRequest);
    ProductResponse getProductById(long id) throws ProductException;
    void reduceQuantity(long id,int quantity) throws ProductException;
}
