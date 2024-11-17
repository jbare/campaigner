package app.welcome;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WelcomeRepository extends MongoRepository<Person, String> {

    public Person findFirstByName(String name);
    public List<Person> findAllByName(String name);

}
