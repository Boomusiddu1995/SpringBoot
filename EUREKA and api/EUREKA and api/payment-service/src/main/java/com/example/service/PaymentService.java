package com.example.service;

import com.example.entity.Payment;
import com.example.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepo.save(payment);
//        System.out.println("Before saving: " + payment);
//        Payment savedPayment = paymentRepo.save(payment);
//        System.out.println("After saving: " + savedPayment);
//        return savedPayment;
    }

    public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"false";
    }


}
