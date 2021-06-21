package com.mohdfai.metrocard.service;

import com.mohdfai.metrocard.domain.Card;
import com.mohdfai.metrocard.domain.Transaction;

@FunctionalInterface
public interface RefundService {
    Double computeRefund(Card card, Transaction transaction, Double cardMaxFare);
}
