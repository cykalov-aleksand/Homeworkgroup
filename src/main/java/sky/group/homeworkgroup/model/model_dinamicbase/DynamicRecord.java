package sky.group.homeworkgroup.model.model_dinamicbase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DynamicRecord(
        @JsonProperty("product_name") String productName,
        @JsonProperty("product_id") String productId,
        @JsonProperty("product_text") String text,
        @JsonProperty("rule") List<Rule> rule
) {
}
