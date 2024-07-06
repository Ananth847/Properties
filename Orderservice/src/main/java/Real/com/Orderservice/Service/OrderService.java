package Real.com.Orderservice.Service;
import Real.com.Orderservice.Entity.Order;
import Real.com.Orderservice.Model.OrderRequest;
import Real.com.Orderservice.Repository.OrderRepo;
import Real.com.Orderservice.ServiceImp.OrderServiceImp;
import Real.com.Orderservice.Client.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductService productService;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        Order order= Order.builder()
                .productId(orderRequest.getProductId())
                        .price(orderRequest.getPrice())
                                .orderDate(Instant.now())
                                        .orderStatus("CREATED")
                                                .quantity(orderRequest.getQuantity()).
        build();
        orderRepo.save(order);
        return order.getOrderId();
    }
}
