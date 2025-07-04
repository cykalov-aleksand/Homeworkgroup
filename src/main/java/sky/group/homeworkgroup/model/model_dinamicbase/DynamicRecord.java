package sky.group.homeworkgroup.model.model_dinamicbase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Модель с характеристиками предлагаемого продукта получаемая с JSON запроса")
public record DynamicRecord(
       @JsonProperty("product_name") String productName,
        @JsonProperty("product_id") String productId,
        @JsonProperty("product_text") String text,
       @Schema(description = "Описание условия при которых продукт может быть предложен клиенту")
        @JsonProperty("rule") List<Rule> rule
) {
}
