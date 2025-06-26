package sky.group.homeworkgroup.model.model_dinamicbase;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;
@Embeddable
public class Statistic {
    @JsonProperty("rule_id")
    @Column(nullable = false, name = "rule_id")
    private Long ruleId;

    private Integer count;

    public Statistic() {
    }

    public Statistic(Long ruleId, Integer count) {
        this.ruleId = ruleId;
        this.count = count;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}