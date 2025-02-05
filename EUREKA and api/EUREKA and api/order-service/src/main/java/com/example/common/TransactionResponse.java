package com.example.common;

import com.example.entity.OrderDemo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class TransactionResponse {
    private OrderDemo orderDemo;
    private double amount;
    private String transactionId;
    private String message;

    public OrderDemo getOrderDemo() {
        return orderDemo;
    }

    public void setOrderDemo(OrderDemo orderDemo) {
        this.orderDemo = orderDemo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransactionResponse() {
    }

    public TransactionResponse(OrderDemo orderDemo, double amount, String transactionId, String message) {
        this.orderDemo = orderDemo;
        this.amount = amount;
        this.transactionId = transactionId;
        this.message = message;
    }
}
