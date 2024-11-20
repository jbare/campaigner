package app.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TallyController {
    @Autowired
    private TallyRepository repository;

    @GetMapping("/tallies")
    public List<String> getAllTallies() {
        return repository.findAll().stream()
                .map(Tally::toString)
                .toList();
    }

    @PostMapping("/tallies")
    public void submitTallies(@RequestBody final List<Tally> tallies) {
        repository.saveAll(
                tallies.stream()
                        .map(t -> t.hasDate() ? t : t.newWithDate(new Date()))
                        .toList());
    }

}
