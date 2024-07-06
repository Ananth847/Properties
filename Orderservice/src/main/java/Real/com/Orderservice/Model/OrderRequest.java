package Real.com.Orderservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long productId;
    private double price;
    private int quantity;
    private PaymentMethod paymentMethod;
}
