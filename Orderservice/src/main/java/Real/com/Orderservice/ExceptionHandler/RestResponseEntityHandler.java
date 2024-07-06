package Real.com.Orderservice.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse1> handleException(OrderException orderException) {
        ErrorResponse1 errorResponse = ErrorResponse1.builder()
                .message(orderException.getMessage())
                .error(orderException.getError())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
