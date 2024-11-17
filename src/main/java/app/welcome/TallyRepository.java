package app.welcome;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TallyRepository extends MongoRepository<Tally, String> {

}
