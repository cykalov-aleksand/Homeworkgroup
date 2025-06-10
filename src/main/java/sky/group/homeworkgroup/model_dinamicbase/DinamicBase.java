package sky.group.homeworkgroup.model_dinamicbase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
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
        private Boolean user_of;
        private Boolean active_rules_of;
        private Boolean transaction_sum_compare;
        private Boolean transaction_sum_compare_deposit_withdraw;

        public NotificationTask() {
        }

        public NotificationTask(Long id, UUID product_id, String product_name, String product_text, Boolean user_of,
                                Boolean active_rules_of, Boolean transaction_sum_compare, Boolean transaction_sum_compare_deposit_withdraw) {
            Id = id;
            this.product_id = product_id;
            this.product_name = product_name;
            this.product_text = product_text;
            this.user_of = user_of;
            this.active_rules_of = active_rules_of;
            this.transaction_sum_compare = transaction_sum_compare;
            this.transaction_sum_compare_deposit_withdraw = transaction_sum_compare_deposit_withdraw;
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

        public Boolean getUser_of() {
            return user_of;
        }

        public void setUser_of(Boolean user_of) {
            this.user_of = user_of;
        }

        public Boolean getActive_rules_of() {
            return active_rules_of;
        }

        public void setActive_rules_of(Boolean active_rules_of) {
            this.active_rules_of = active_rules_of;
        }

        public Boolean getTransaction_sum_compare() {
            return transaction_sum_compare;
        }

        public void setTransaction_sum_compare(Boolean transaction_sum_compare) {
            this.transaction_sum_compare = transaction_sum_compare;
        }

        public Boolean getTransaction_sum_compare_deposit_withdraw() {
            return transaction_sum_compare_deposit_withdraw;
        }

        public void setTransaction_sum_compare_deposit_withdraw(Boolean transaction_sum_compare_deposit_withdraw) {
            this.transaction_sum_compare_deposit_withdraw = transaction_sum_compare_deposit_withdraw;
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
