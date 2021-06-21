package com.mohdfai.metrocard.rest;

/**
 * @author mohdfai
 */
public class BalanceIsBelowException extends IllegalArgumentException {
    public BalanceIsBelowException(String message) {
        super(message);
    }
}
