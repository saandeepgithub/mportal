package com.portal.util;

public class PortalUtils {

    public static PaymentType getPaymentType(Payments paymentMode) {
        if (paymentMode.equals(Payments.AMAZON_PAY) ||
                paymentMode.equals(Payments.GOOGLE_PAY) ||
                paymentMode.equals(Payments.PAYTM) ||
                paymentMode.equals(Payments.PHONE_PAY)) {
            return PaymentType.WALLETS;
        } else if (paymentMode.equals(Payments.CREDIT_CARD)
                || paymentMode.equals(Payments.DEBIT_CARD)) {
            return PaymentType.CARDS;
        } else if (paymentMode.equals(Payments.CASH)) {
            return PaymentType.CASH;
        } else {
            return PaymentType.CASHABCK;
        }
    }
}
