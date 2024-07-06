package Real.com.Orderservice.ExceptionHandler;

import lombok.Data;

@Data
public class OrderException extends Exception{
    private  String error;
    private String message;
    public OrderException(String message, String error){
        this.error=error;
        this.message=message;
    }
}
