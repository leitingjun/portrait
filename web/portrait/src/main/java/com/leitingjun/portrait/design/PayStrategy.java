package com.leitingjun.portrait.design;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
