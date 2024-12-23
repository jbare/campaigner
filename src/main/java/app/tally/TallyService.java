package app.tally;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TallyService {
    private static final String TALLY_TOPIC = "tally_topic";

    private final TallyRepository tallyRepository;

    public TallyService(final TallyRepository tallyRepository) {
        this.tallyRepository = tallyRepository;
    }

    @KafkaListener(topics = TALLY_TOPIC)
    public void receiveTally(final Tally tally) {
        System.out.println("Receiving tally: " + tally);

        tallyRepository.save(tally);
    }

}
