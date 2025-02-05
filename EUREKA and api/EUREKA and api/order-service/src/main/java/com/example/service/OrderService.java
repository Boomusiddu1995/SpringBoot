package com.example.service;


import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.OrderDemo;
import com.example.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@RefreshScope
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

//    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
//    private String ENDPOINT_URL;


//    public OrderDemo bookOrder(OrderDemo demo){
//        return orderRepo.save(demo);
//    }

    public TransactionResponse bookOrder(TransactionRequest request){
        String response="";
        OrderDemo orderDemo=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(orderDemo.getId());
        payment.setAmount(orderDemo.getPrice());
//        Payment paymentResponse = restTemplate.postForObject("http://localhost:8089/payment/doPayment",payment, Payment.class);
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment, Payment.class);
//        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL,payment, Payment.class);

        response=paymentResponse.getPaymentStatus().equals("success")?"payment processing successful":"payment failed";
         orderRepo.save(orderDemo);
         return new TransactionResponse(orderDemo,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }

}
