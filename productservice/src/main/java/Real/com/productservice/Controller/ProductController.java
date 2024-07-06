package Real.com.productservice.Controller;
import Real.com.productservice.Entity.Product;
import Real.com.productservice.Exception.ProductException;
import Real.com.productservice.Model.ProductRequest;
import Real.com.productservice.Model.ProductResponse;
import Real.com.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/addproduct")
    public ResponseEntity<Long> saveProduct(@RequestBody ProductRequest productRequest) {
        Product product1 = productService.saveProduct(productRequest);
        return new ResponseEntity<>(product1.getProductId(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) throws ProductException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("reducequantity/{id}")
    public ResponseEntity <Void> reduceQuantity(@PathVariable long id,@RequestParam int quantity) throws ProductException {
          productService.reduceQuantity(id,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}