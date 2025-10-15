package org.example.mscardtrenyol.exception;

import org.example.mscardtrenyol.exception.custom.NotFoundException;
import org.example.mscardtrenyol.exception.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Response.builder()
                        .message(ex.getMessage())
                        .code("NOT_FOUND")
                        .build());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleOther(Exception ex) {
        return ResponseEntity.status(500)
                .body(Response.builder()
                        .message(ex.getMessage())
                        .code("INTERNAL_ERROR")
                        .build());
    }


}
