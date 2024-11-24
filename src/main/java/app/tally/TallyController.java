package app.tally;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class TallyController {
    private final TallyRepository repository;
    private final KafkaTemplate<String, Tally> kafkaTemplate;

    public TallyController(final TallyRepository repository,
                           final KafkaTemplate<String, Tally> kafkaTemplate) {
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
        tallies.stream()
                .map(t -> t.hasDate() ? t : t.newWithDate(new Date()))
                .forEach(t -> kafkaTemplate.send("tally_topic", t));

        repository.saveAll(
                tallies.stream()
                        .map(t -> t.hasDate() ? t : t.newWithDate(new Date()))
                        .toList());
    }

}
