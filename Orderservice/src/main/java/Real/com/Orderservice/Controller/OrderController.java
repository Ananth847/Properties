package Real.com.Orderservice.Controller;
import Real.com.Orderservice.Model.OrderRequest;
import Real.com.Orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/order")
public class OrderController{
    @Autowired
    OrderService orderService;
    @PostMapping("/placeorder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        long order= orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(order, HttpStatus.OK);
     }
}