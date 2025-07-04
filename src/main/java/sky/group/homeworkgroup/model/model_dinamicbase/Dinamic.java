package sky.group.homeworkgroup.model.model_dinamicbase;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Schema(description = "Модель с характеристиками предлагаемого продукта, поля которого приведены к виду пригодному для дальнейшей обработки в приложении")
@Entity
public class Dinamic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name = "product_id")
    private String productId;
    @Column(nullable = false, name = "product_name")
    private String productName;
    @Column(columnDefinition = "TEXT", nullable = false, name = "product_text")
    private String productText;
    @Schema(description = "Описание условия при которых продукт может быть предложен клиенту")
    @OneToMany(mappedBy = "dinam")
    private List<Rule> rule;

    public Dinamic(String productId, String productName, String productText, List<Rule> rule) {
        this.productId = productId;
        this.productName = productName;
        this.productText = productText;
        this.rule = rule;
    }

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public List<Rule> getRule() {
        return rule;
    }

    public void setRule(List<Rule> rule) {
        this.rule = rule;
    }
}