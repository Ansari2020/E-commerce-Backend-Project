package org.example.ecommerce.Dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExceptionDto {
    private String message;
    private String resolution;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
