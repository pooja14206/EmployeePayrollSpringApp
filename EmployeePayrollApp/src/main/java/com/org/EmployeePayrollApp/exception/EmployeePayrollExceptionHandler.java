package com.org.EmployeePayrollApp.exception;

import com.org.EmployeePayrollApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeePayrollExceptionHandler{

    /*
    * @method: If any Field is not match validation condition it will Handle and show proper exception message.
    *
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException (MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request.", errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    /*
     * @method: If Provided date is not Correct this method will handle it and show proper message.
     *
     */
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException (
//            HttpMessageNotReadableException exception) {
//        log.error("Invalid Date Format", exception);
//        ResponseDTO responseDTO = new ResponseDTO(message,
//                "Should have date in the format dd MM yyyy");
//        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookException(EmployeePayrollException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Requests", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

}
