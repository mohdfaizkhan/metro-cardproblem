package com.mohdfai.metrocard.rest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @author mohdfai
 */
@ControllerAdvice
public class RouterControllerAdvice {

    @ExceptionHandler(BalanceIsBelowException.class)
    public Mono balanceIsBelowException(final BalanceIsBelowException exception) {
        return Mono.error(exception);
    }

    @ExceptionHandler(AlreadyCheckedInException.class)
    public Mono balanceIsBelowException(final AlreadyCheckedInException exception) {
        return Mono.error(exception);
    }

}
