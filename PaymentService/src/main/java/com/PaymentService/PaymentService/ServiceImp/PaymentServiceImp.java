package com.PaymentService.PaymentService.ServiceImp;

import com.PaymentService.PaymentService.Model.PaymentRequest;
import com.PaymentService.PaymentService.Model.PaymentResponse;

public interface PaymentServiceImp {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(long orderId);
}
