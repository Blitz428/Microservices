package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class OrderItem {
    private String orderId;
    private String foodId;
    private int quantity;
    private String note;
    private boolean note4all;
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