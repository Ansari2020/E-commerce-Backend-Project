package org.example.ecommerce.ExceptionHandler;


import org.example.ecommerce.Dtos.ExceptionDto;
import org.example.ecommerce.Dtos.ProductNotFoundExceptionDto;
import org.example.ecommerce.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleAirthmeticException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("ArithmeticException occurred");
        dto.setResolution("please try again. and check your calculation");
        ResponseEntity<ExceptionDto> responseEntity=new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> indexOutOfBoundsException(){
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage("Product not found with given id "+exception.getId());
        ResponseEntity<ProductNotFoundExceptionDto> responseEntity=
                new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
