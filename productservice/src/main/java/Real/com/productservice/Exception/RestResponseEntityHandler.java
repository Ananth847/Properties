package Real.com.productservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import Real.com.productservice.Model.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductException productException) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(productException.getMessage())
                .error(productException.getError())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
