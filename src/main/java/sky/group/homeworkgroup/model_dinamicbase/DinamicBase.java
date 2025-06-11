package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class DinamicBase {
    @Entity
    public class NotificationTask {
        @jakarta.persistence.Id
        @GeneratedValue
        private Long Id;
        private UUID product_id;
        private String product_name;
        private String product_text;
        @OneToMany(mappedBy = "rule_id")
        private List<ModelRequest> modelRequests;

        public NotificationTask() {
        }

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public UUID getProduct_id() {
            return product_id;
        }

        public void setProduct_id(UUID product_id) {
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

        public List<ModelRequest> getModelRequests() {
            return modelRequests;
        }

        public void setModelRequests(List<ModelRequest> modelRequests) {
            this.modelRequests = modelRequests;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof NotificationTask that)) return false;
            return Objects.equals(Id, that.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(Id);
        }
    }
}
