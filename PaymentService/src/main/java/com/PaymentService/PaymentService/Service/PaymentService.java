package com.PaymentService.PaymentService.Service;
import com.PaymentService.PaymentService.Entity.PaymentDetails;
import com.PaymentService.PaymentService.Model.PaymentMode;
import com.PaymentService.PaymentService.Model.PaymentRequest;
import com.PaymentService.PaymentService.Model.PaymentResponse;
import com.PaymentService.PaymentService.Repository.PaymentRepo;
import com.PaymentService.PaymentService.ServiceImp.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentService implements PaymentServiceImp {
    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .amount(paymentRequest.getAmount())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .build();
        paymentRepo.save(paymentDetails);
        return paymentDetails.getPaymentId();
    }

    @Override
    public PaymentResponse getPaymentDetails(long orderId) {
        PaymentDetails paymentDetails = paymentRepo.findById(orderId).get();
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .amount(paymentDetails.getAmount())
                .orderId(paymentDetails.getOrderId())
                .paymentDate(paymentDetails.getPaymentDate())
                .paymentId(paymentDetails.getPaymentId())
                .status(paymentDetails.getPaymentStatus())
                .paymentMode(PaymentMode.valueOf(paymentDetails.getPaymentMode()))
                .build();
        return paymentResponse;
    }
}
