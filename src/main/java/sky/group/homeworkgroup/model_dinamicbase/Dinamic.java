package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Entity
public class Dinamic {
    @Id
    @GeneratedValue
    private Long id;
    private String product_id;
    private String product_name;
    private String product_text;
    @OneToMany(mappedBy = "dinamic")
    List<Rulle> rulle;

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

    public String getProduct_text() {
        return product_text;
    }

    public void setProduct_text(String product_text) {
        this.product_text = product_text;
    }

    public List<Rulle> getRulle() {
        return rulle;
    }

    public void setRulle(List<Rulle> rulle) {
        this.rulle = rulle;
    }
}
