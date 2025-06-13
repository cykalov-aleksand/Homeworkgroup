package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Argument {
    @Id
    @GeneratedValue
    private long id;
    String name;
     @ManyToOne
     @JoinColumn(name = "argument_id")
    private Rulle argument;
    Argument(){}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Argument argument)) return false;
        return id == argument.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
