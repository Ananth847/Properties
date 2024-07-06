package Real.com.Orderservice.ExceptionDecoder;

import Real.com.Orderservice.ExceptionHandler.ErrorResponse1;
import Real.com.Orderservice.ExceptionHandler.OrderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            ErrorResponse1 errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse1.class);
            return new OrderException(errorResponse.getMessage(), errorResponse.getError());
        } catch (IOException e) {
            e.printStackTrace();
            return new OrderException("ServiceInternalException", "SERVICE_EXCEPTION");
        }
    }
}
