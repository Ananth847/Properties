package Real.com.Orderservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="order_Table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orderId;
    private long productId;
    private double price;
    private Instant orderDate;
    private String orderStatus;
    private int quantity;
}
