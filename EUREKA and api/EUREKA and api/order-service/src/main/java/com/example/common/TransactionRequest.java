package com.example.common;

import com.example.entity.OrderDemo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest
{
    private OrderDemo order;
    private Payment payment;

    public OrderDemo getOrder() {
        return order;
    }

    public void setOrder(OrderDemo order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
