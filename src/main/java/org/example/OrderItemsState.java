package org.example;

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
    private List<OrderItem> items = new ArrayList<>();
    private String tableId;
    private OrderStateEnum state;

    @Builder
    public OrderItemsState(List<OrderItem> items, String tableId, OrderStateEnum state)
    {
        this.items=items;
        this.tableId=tableId;
        this.state=state;


    }


}
