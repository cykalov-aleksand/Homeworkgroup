package sky.group.homeworkgroup.model_dinamicbase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity
public class Rule {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "dinamic_id")
   Dinamic dinam;
    private String query;
    private List<String> arguments;
    private Boolean negate;

    public Rule() { }


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

    public Dinamic getDinam() {
        return dinam;
    }

    @JsonIgnore
    public void setDinam(Dinamic dinam) {
        this.dinam = dinam;
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
                ", dinam=" + dinam +
                ", query='" + query + '\'' +
                ", arguments=" + arguments +
                ", negate=" + negate +
                '}';
    }
}
