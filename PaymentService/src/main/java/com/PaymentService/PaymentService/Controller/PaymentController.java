package com.PaymentService.PaymentService.Controller;

import com.PaymentService.PaymentService.Model.PaymentRequest;
import com.PaymentService.PaymentService.Model.PaymentResponse;
import com.PaymentService.PaymentService.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController{
    @Autowired
    PaymentService paymentService;
    @PostMapping("dopayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        long paymentRequest1=  paymentService.doPayment(paymentRequest);
        return new ResponseEntity<>(paymentRequest1, HttpStatus.OK);
    }
    @GetMapping("getorderdetails/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long orderId){
        PaymentResponse paymentResponse = paymentService.getPaymentDetails(orderId);
        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
    }


}
