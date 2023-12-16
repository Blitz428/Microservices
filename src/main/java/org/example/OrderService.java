package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

OrderItem orderItem = new OrderItem();

@Autowired
List<OrderItem> orderItems = new ArrayList<>();
    public void createItem(String orderId,String foodId, int quantity, String note, boolean note4all, String groupName){
        orderItem.setOrderId(orderId);
        orderItem.setFoodId(foodId);
        orderItem.setQuantity(quantity);
        orderItem.setNote(note);
        orderItem.setNote4all(note4all);
        orderItem.setGroupName(groupName);
        orderItems.add(orderItem);
    }

    public List<OrderItem> getItems(){
        return  orderItems;
    }

    public OrderItem getOneItem(String orderId){

        if (!orderItems.isEmpty())
        {
        for (OrderItem item: orderItems
             ) {
            if (item.getOrderId().equals(orderId)){

                return item;
            }
        }

        }
        return null;
    }

    public OrderItem updateItem(String orderId,String foodId, int quantity, String note, boolean note4all, String groupName)
    {
        if (!orderItems.isEmpty())
        {
            for (OrderItem item: orderItems
            ) {
                if (item.getOrderId().equals(orderId)){

                    item.setFoodId(foodId);
                    item.setQuantity(quantity);
                    item.setNote(note);
                    item.setNote4all(note4all);
                    item.setGroupName(groupName);
                    return item;
                }
            }

        }
        return null;
    }

    public List<OrderItem>deleteItem(String orderId)
    {
        if (!orderItems.isEmpty())
        {
            orderItems.removeIf(item -> item.getOrderId().equals(orderId));

        }

        return orderItems;
    }

}
