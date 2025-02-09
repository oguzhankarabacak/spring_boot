package com.oguzhan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }
    //Catch errors that throwed by spring validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)  //bu hata ile karşılaşırsan
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        Map<String, List<String>> errorsMap = new HashMap<>();
        for (ObjectError objError : errorList) {
            String fieldName = ((FieldError)objError).getField(); //It give name of variable that cause error //firstName, lastName
            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
            }
            else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
            }
        }
        ApiError apiError = createApiError(errorsMap);
        return ResponseEntity.badRequest().body(apiError);
    }
    private <T> ApiError<T> createApiError(T errors) { //can be list or map or string
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }

}
