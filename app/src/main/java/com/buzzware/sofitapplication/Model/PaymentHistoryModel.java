package com.buzzware.sofitapplication.Model;

public class PaymentHistoryModel {
    int paycardImageview;
    String cardnameTV;

    public PaymentHistoryModel(int paycardImageview, String cardnameTV) {
        this.paycardImageview = paycardImageview;
        this.cardnameTV = cardnameTV;
    }

    public int getPaycardImageview() {
        return paycardImageview;
    }

    public void setPaycardImageview(int paycardImageview) {
        this.paycardImageview = paycardImageview;
    }

    public String getCardnameTV() {
        return cardnameTV;
    }

    public void setCardnameTV(String cardnameTV) {
        this.cardnameTV = cardnameTV;
    }
}
