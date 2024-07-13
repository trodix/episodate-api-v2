package com.trodix.episodate.v2.episodateapi.presentation;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    public static class ApiError {
        private HttpStatus status;
        private OffsetDateTime timestamp = OffsetDateTime.now();
        private String message;
        private String details;

        public ApiError(HttpStatus status, String message, String details) {
            this.status = status;
            this.message = message;
            this.details = details;
        }
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> errorMessages = new ArrayList<>();

        for (FieldError fieldError : ex.getFieldErrors()) {
            errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ApiError response = new ApiError(HttpStatus.BAD_REQUEST, "Request is invalid", String.join(", ", errorMessages));

        return handleExceptionInternal(ex, response, headers, status, request);
    }

}
