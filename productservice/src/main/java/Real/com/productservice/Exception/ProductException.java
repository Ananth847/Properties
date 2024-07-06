package Real.com.productservice.Exception;

import lombok.Data;

@Data
public class ProductException extends Exception{
    private  String error;
    private String message;
    public ProductException(String message,String error){
        this.error=error;
        this.message=message;
    }
}
