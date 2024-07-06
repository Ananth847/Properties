package Real.com.productservice.Service;
import Real.com.productservice.Entity.Product;
import Real.com.productservice.Exception.ProductException;
import Real.com.productservice.Model.ProductRequest;
import Real.com.productservice.Model.ProductResponse;
import Real.com.productservice.Repository.ProductRepo;
import Real.com.productservice.ServiceImp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    ProductRepo productRepo;
    @Override
    public Product saveProduct(ProductRequest productRequest) {
        Product product=Product.builder().
                productName(productRequest.getProductName()).
                price(productRequest.getPrice()).
                quantity(productRequest.getQuantity()).build();
        return productRepo.save(product);
    }
    @Override
    public ProductResponse getProductById(long id) throws ProductException {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductName(product.getProductName());
            productResponse.setPrice(product.getPrice());
            productResponse.setQuantity(product.getQuantity());
            return productResponse;
        } else {
            throw new ProductException("Product ID not found","Product not found");
        }
    }

    @Override
    public void reduceQuantity(long id, int quantity) throws ProductException {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductException("Product id " + id + " not found", "Product not found");
        }
        Product product = productOptional.get();

        int currentQuantity = product.getQuantity();
        if (currentQuantity < quantity) {
            throw new ProductException("Insufficient quantity available", "Quantity reduction failed");
        }
        product.setQuantity(currentQuantity - quantity);

        productRepo.save(product);
    }


}
