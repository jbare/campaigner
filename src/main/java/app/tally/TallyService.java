package app.tally;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TallyService {

    private final TallyRepository tallyRepository;

    public TallyService(final TallyRepository tallyRepository) {
        this.tallyRepository = tallyRepository;
    }

    @KafkaListener(topics = "tally_topic", groupId = "campaigner_group")
    public void receiveMessage(final Tally tally) {
        tallyRepository.save(tally);
    }

    @KafkaListener(topics = "test_topic", groupId = "test_group")
    public void receiveMessage(final String message) {
        System.out.println("Received this through Kafka: " + message);
    }
}
