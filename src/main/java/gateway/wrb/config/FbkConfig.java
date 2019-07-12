package gateway.wrb.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class FbkConfig {
    @Value("${path.fbk}")
    private String rv001Path;
}
