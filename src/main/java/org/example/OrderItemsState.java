package org.example;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class OrderItemsState {
    @Schema(description = "Rendelések listája")
    private List<OrderItem> items = new ArrayList<>();
    @Schema(description = "Asztal azonosító")
    private String tableId;
    @Schema(description = "Rendelés állapota")
    private OrderStateEnum state;

    @Builder
    public OrderItemsState(List<OrderItem> items, String tableId, OrderStateEnum state)
    {
        this.items=items;
        this.tableId=tableId;
        this.state=state;


    }


}
