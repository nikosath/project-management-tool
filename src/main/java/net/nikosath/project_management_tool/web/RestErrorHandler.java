package net.nikosath.project_management_tool.web;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleError(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .collect(tofieldErrorToMsgMap());
    }

    private Collector<FieldError, ?, Map<String, String>> tofieldErrorToMsgMap() {
        return Collectors.toMap(
                FieldError::getField,
                fieldError -> Objects.toString(fieldError.getDefaultMessage(), "")
        );
    }

}
