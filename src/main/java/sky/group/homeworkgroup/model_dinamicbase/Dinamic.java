package sky.group.homeworkgroup.model_dinamicbase;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Dinamic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product_id;
    private String product_name;
   private String product_text;
    @OneToMany(mappedBy = "dinam")
    private List<Rule> rule;


    public Dinamic() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Dinamic dinamic)) return false;
        return Objects.equals(id, dinamic.id);
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
@Lob
    public String getProduct_text() {
        return product_text;
    }

    public void setProduct_text(String product_text) {
        this.product_text = product_text;
    }

    public List<Rule> getRule() {
        return rule;
    }

    public void setRule(List<Rule> rule) {
        this.rule = rule;
    }

}
