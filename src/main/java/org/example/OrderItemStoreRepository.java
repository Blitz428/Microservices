package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
@Service
public class OrderItemStoreRepository {
    private static final Map<String,List<OrderItemsState>> ordersrepository = new HashMap<>();

    public void add(String tableId, List<OrderItemsState> orders)
    {
        if (getAll(tableId).isEmpty()){
            ordersrepository.put(tableId,orders);
        }
    }
    public void modifyState(String tableId,String orderId, OrderStateEnum state){
        for (OrderItemsState order:ordersrepository.get(tableId)
             ) {
            for (OrderItem item:order.getItems()
                 ) {
                if (item.getOrderId().equals(orderId)){
                    order.setState(state);
                }
            };

        }

    }

    public void delete(String orderId, String tableId){
        for (OrderItemsState order:ordersrepository.get(tableId)
        ) {
            order.getItems().removeIf(item -> item.getOrderId().equals(orderId));


        }
    }

    public void clear(String tableId)
    {
        for (OrderItemsState order:ordersrepository.get(tableId)
        ) {
            order.getItems().clear();

        }
    }

    public List<OrderItemsState> getAll(String tableId){
        return ordersrepository.get(tableId);
    }

}
