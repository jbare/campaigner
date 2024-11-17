package app.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {
    @Autowired
    private WelcomeRepository repository;

    @GetMapping("/welcome")
    public List<String> welcome() {
        return repository.findAll().stream()
                .map(Person::toString)
                .toList();
    }

}
