package sky.group.homeworkgroup.model.model_dinamicbase;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Rule {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dinamic_id")
    Dinamic dinam;
    private String query;
    private List<String> arguments;
    private Boolean negate;

    public Rule() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Rule rule)) return false;
        return Objects.equals(id, rule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public Boolean getNegate() {
        return negate;
    }

    public void setNegate(Boolean negate) {
        this.negate = negate;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", arguments=" + arguments +
                ", negate=" + negate +
                '}';
    }
}
