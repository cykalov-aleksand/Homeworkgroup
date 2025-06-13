package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Rulle {
   @Id
    @GeneratedValue
    private Long id;
    private String query;

   @OneToMany(mappedBy = "argument")
   Set<Argument> argument_id;
    private Boolean negative;

   @ManyToOne
   @JoinColumn(name = "rulle")
   private Dinamic dinamic;
public Rulle(){}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Rulle that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getNegative() {
        return negative;
    }

    public void setNegative(Boolean negative) {
        this.negative = negative;
    }

    public Set<Argument> getArgument_id() {
        return argument_id;
    }

    public void setArgument_id(Set<Argument> argument_id) {
        this.argument_id = argument_id;
    }
}
