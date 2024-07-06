package Real.com.Orderservice.Config;

import Real.com.Orderservice.ExceptionDecoder.CustomDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecoderConfig {
    @Bean
    public ErrorDecoder createConfig() {
        return new CustomDecoder();
    }
}
