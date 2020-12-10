package com.example.demo.commons.domains.response;

import com.example.demo.commons.enums.TransactionState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseResponse<T> implements Serializable {

    private T body;
    private HttpStatus status;
    private String businessStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timeResponse;
    private String message;
    private String path;
    private TransactionState transactionState;

    public BaseResponse(T body, HttpStatus status, String businessStatus, LocalDateTime timeResponse, String message, String path, TransactionState transactionState) {
        this.body = body;
        this.status = status;
        this.businessStatus = businessStatus;
        this.timeResponse = timeResponse;
        this.message = message;
        this.path = path;
        this.transactionState = transactionState;
    }


}
