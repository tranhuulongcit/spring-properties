package info.cafeit.springproperties.config;


import info.cafeit.springproperties.model.Google;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource(value = "classpath:cafeit-config.properties")
@ConfigurationProperties(prefix = "cafeit")
public class CafeitConfig {
    private String resourceRoot;
    private Boolean socialAutoSignup;
    private Integer recordPerPage;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Google google;
}
