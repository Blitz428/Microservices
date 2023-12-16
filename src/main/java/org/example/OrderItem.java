package org.example;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class OrderItem {
    @Schema(description = "Rendelési azonosító")
    private String orderId;
    @Schema(description = "Étel azonosító")
    private String foodId;
    @Schema(description = "Rendelés mennyisége")
    private int quantity;
    @Schema(description = "Megjegyzés")
    private String note;
    @Schema(description = "Mindenkinek")
    private boolean note4all;
    @Schema(description = "Csoport neve")
    private String groupName;

    @Builder
    public OrderItem(String orderId, String foodId, int quantity, String note, boolean note4all, String groupName)
    {
        this.foodId=foodId;
        this.quantity=quantity;
        this.note=note;
        this.note4all=note4all;
        this.groupName=groupName;
        this.orderId=orderId;
    }

}
