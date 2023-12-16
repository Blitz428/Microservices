package org.example;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Feedback {
    @Schema(description = "Visszajelzés azonosító")
    private String feedbackId;
    @Schema(description = "Rendelés")
    private OrderItem orderItem;
    @Schema(description = "Visszajelzés")
    private String feedbacktext;
    @Schema(description = "Rendelő neve")
    private String orderPerson;

    @Builder
    public Feedback(String feedbackId,OrderItem orderItem,String feedbacktext, String orderPerson)
    {
        this.feedbackId=feedbackId;
        this.feedbacktext=feedbacktext;
        this.orderItem=orderItem;
        this.orderPerson=orderPerson;
    }
}
