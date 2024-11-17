package app.welcome;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "tallies")
public class Tally {

    @Id
    private final String id;
    private final Long signatures;
    private final Long money;
    private final Long pamphlets;

    public Tally(final String id, final Long signatures, final Long money, final Long pamphlets) {
        this.id = id;
        this.signatures = signatures;
        this.money = money;
        this.pamphlets = pamphlets;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        final Tally tally = (Tally) o;
        return Objects.equals(signatures, tally.signatures) && Objects.equals(money, tally.money) && Objects.equals(pamphlets, tally.pamphlets);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(signatures);
        result = 31 * result + Objects.hashCode(money);
        result = 31 * result + Objects.hashCode(pamphlets);
        return result;
    }

    @Override
    public String toString() {
        return "Tally{" +
                "id='" + id + '\'' +
                ", signatures=" + signatures +
                ", money=" + money +
                ", pamphlets=" + pamphlets +
                '}';
    }
}
