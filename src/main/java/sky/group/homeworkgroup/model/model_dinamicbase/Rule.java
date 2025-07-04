package sky.group.homeworkgroup.model.model_dinamicbase;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Schema(description = "Модель описание условия при которых продукт может быть предложен клиенту")
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
    @Schema(description = "Модель анализа данных по статистике использования данного совета")
    @Embedded
    private Statistic statistic;

    public Rule() {
    }

    public Rule(Long id, String query, List<String> arguments, Boolean negate) {
        this.id = id;
        this.query = query;
        this.arguments = arguments;
        this.negate = negate;
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

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
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
        return "{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", arguments=" + arguments +
                ", negate=" + negate +
                '}';
    }
}
