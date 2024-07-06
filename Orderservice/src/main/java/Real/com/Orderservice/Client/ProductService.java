package Real.com.Orderservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice/product")
public interface ProductService {
    @PutMapping("reducequantity/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable long id, @RequestParam int quantity);

}

//this interface is used for to communicate between the product service and the order service.