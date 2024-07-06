package Real.com.Orderservice.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PaymentService/payment")
public interface PaymentService {

    @PostMapping("dopayment")
   ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
//this interface is used for to communicate between the Payment service and the order service.