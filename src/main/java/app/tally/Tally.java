package app.tally;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "tallies")
public class Tally {

    @Id
    private final String id;
    private final Long signatures;
    private final Double money;
    private final Long pamphlets;
    private final Date date;

    @JsonCreator
    public Tally(@JsonProperty("id") final String id,
                 @JsonProperty("signatures") final Long signatures,
                 @JsonProperty("money") final Double money,
                 @JsonProperty("pamphlets") final Long pamphlets,
                 @JsonProperty("date") final Date date) {
        this.id = id;
        this.signatures = signatures;
        this.money = money;
        this.pamphlets = pamphlets;
        this.date = date;
    }

    public Tally newWithDate(final Date date) {
        return new Tally(this.id, this.signatures, this.money, this.pamphlets, date);
    }

    public boolean hasDate() {
        return this.date != null;
    }

    public String getId() {
        return id;
    }

    public Long getSignatures() {
        return signatures;
    }

    public Double getMoney() {
        return money;
    }

    public Long getPamphlets() {
        return pamphlets;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        final Tally tally = (Tally) o;
        return Objects.equals(signatures, tally.signatures) &&
                Objects.equals(money, tally.money) &&
                Objects.equals(pamphlets, tally.pamphlets) &&
                Objects.equals(date, tally.date);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(signatures);
        result = 31 * result + Objects.hashCode(money);
        result = 31 * result + Objects.hashCode(pamphlets);
        result = 31 * result + Objects.hashCode(date);
        return result;
    }

    @Override
    public String toString() {
        return "Tally{" +
                "id='" + id + '\'' +
                ", signatures=" + signatures +
                ", money=" + money +
                ", pamphlets=" + pamphlets +
                ", date=" + date +
                '}';
    }
}
