package app;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CampaignerConfiguration {
    @Bean
    public NewTopic tallyTopic() {
        return new NewTopic("tally_topic", 1, (short) 1);
    }

    @Bean
    public NewTopic testTopic() {
        return new NewTopic("test_topic", 1, (short) 1);
    }
}
