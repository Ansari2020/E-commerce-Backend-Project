package org.example.ecommerce.Exception;

public class ProductNotFoundException extends Exception {

    private Long id;
    private String message;
    public ProductNotFoundException(Long id,String message) {
        super(message);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
