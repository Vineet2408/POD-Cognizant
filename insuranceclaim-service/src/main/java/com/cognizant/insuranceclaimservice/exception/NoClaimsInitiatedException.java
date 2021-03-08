package com.cognizant.insuranceclaimservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No claims Initiated")
public class NoClaimsInitiatedException extends Exception {

}