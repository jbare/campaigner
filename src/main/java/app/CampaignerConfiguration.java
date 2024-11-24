package app;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CampaignerConfiguration {
    @Bean
    public NewTopic exampleTopic() {
        return new NewTopic("tally_topic", 1, (short) 1);
    }
}
