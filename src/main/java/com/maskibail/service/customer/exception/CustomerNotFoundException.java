package com.maskibail.service.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "customer not found")
public class CustomerNotFoundException extends RuntimeException {
}
