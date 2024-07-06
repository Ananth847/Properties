package com.PaymentService.PaymentService.Repository;

import com.PaymentService.PaymentService.Entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentDetails,Long> {

}
