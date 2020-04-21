package info.cafeit.springproperties;

import info.cafeit.springproperties.config.CafeitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringPropertiesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesApplication.class, args);
    }

    @Autowired
    private CafeitConfig cafeitConfig;

    @Value("${cafeit.google.appId}")
    private String googleAppId;

    @Autowired
    Environment env;

    @Override
    public void run(String... args) throws Exception {
        //datatype properties
        System.out.println("Resource root: " + cafeitConfig.getResourceRoot());
        System.out.println("Record per page: " + cafeitConfig.getRecordPerPage());

        //Object properties
        System.out.println("Google appId: " + cafeitConfig.getGoogle().getAppId());
        System.out.println("Google appSecret: " + cafeitConfig.getGoogle().getAppSecret());
        System.out.println("Google enable signin: " + cafeitConfig.getGoogle().getEnable());

        //List properties
        System.out.println("List email:");
        cafeitConfig.getDefaultRecipients().forEach(System.out::println);

        //Map Properties
        cafeitConfig.getAdditionalHeaders().forEach((key, value) -> System.out.println("Key: " + key + "   Value: " + value));

        //single value
        System.out.println("Sữ dụng @value: " + googleAppId);

        //get value using env
        System.out.println("Sữ dụng env: " + env.getProperty("cafeit.google.appId"));

    }

}




