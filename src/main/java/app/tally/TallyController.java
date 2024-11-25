package app.tally;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class TallyController {
    private static final String TALLY_TOPIC = "tally_topic";
    private final TallyRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TallyController(final TallyRepository repository,
                           final KafkaTemplate<String, Object> kafkaTemplate
                           ) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/tallies")
    public List<String> getAllTallies() {
        return repository.findAll().stream()
                .map(Tally::toString)
                .toList();
    }

    @PostMapping("/tallies")
    public void submitTallies(@RequestBody final List<Tally> tallies) {
        System.out.println("Submitting tallies: " + tallies);
        tallies.stream()
                .map(t -> t.hasDate() ? t : t.newWithDate(new Date()))
                .forEach(t -> kafkaTemplate.send(TALLY_TOPIC, t));
    }

}
