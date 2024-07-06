package Real.com.Orderservice.ServiceImp;

import Real.com.Orderservice.Model.OrderRequest;

public interface OrderServiceImp {
    long placeOrder(OrderRequest orderRequest);
}
