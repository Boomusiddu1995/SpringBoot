package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    private static final Logger logger = LoggerFactory.getLogger(FallBackController.class);

    @RequestMapping("/orderFallback")
    public String orderServiceCallback(){
        logger.info("Payment Service fallback triggered");
        return "Order service is currently unavailable. Please try again later.";
    }

    @RequestMapping("/paymentFallback")
    public String paymentServiceCallback(){
        return "Payment service is currently unavailable. Please try again later.";
    }
}
