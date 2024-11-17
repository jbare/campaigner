package app.welcome;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "welcomeColl")
public class Person {

    @Id
    public String id;

    public String name;
    public Long age;

    public Person() {}

    public Person(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%s, name='%s', age='%d']",
                id, name, age);
    }

}
