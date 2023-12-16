package org.example;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.OrderStateEnum.delivered;

@RestController()
@RequestMapping(path = "/waiter")
public class WaiterController {


    @Autowired
    OrderItemStoreRepository orderItemStoreRepository;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asztal kifizetve",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderItemsState.class)) }),
            @ApiResponse(responseCode = "500", description = "Sikertelen lekérdezés",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Asztal kifizetése")
    @DeleteMapping(path = "/clear", produces = MediaType.APPLICATION_JSON_VALUE)
    public void payment(@Parameter(description = "Az asztal id-je",required = true) @RequestBody(required = true) String tableId) throws Exception {
        orderItemStoreRepository.clear(tableId);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres rendelés",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderItemsState.class)) }),
            @ApiResponse(responseCode = "500", description = "Sikertelen lekérdezés",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Rendelés rögzítése")
    @PostMapping(path = "/clear", produces = MediaType.APPLICATION_JSON_VALUE)
    public void order(@Parameter(description = "Az asztal id-je",required = true) @RequestBody(required = true) String tableId,
                      @Parameter(description = "Tételek",required = true) @RequestBody(required = true)  List<OrderItemsState> orders) throws Exception {
        orderItemStoreRepository.add(tableId,orders);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Étel kihozva",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderItemsState.class)) }),
            @ApiResponse(responseCode = "500", description = "Nincs ilyen tétel",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Étel kivitele")
    @PutMapping(path = "/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delivery(
            @Parameter(description = "Asztal id-je", required = true) @RequestBody(required = true) String tableId,
            @Parameter(description = "Megrendelések id-je", required = true) @RequestBody(required = true) List<String>  orderId) {
        for (String orderids:orderId
             ) {
            orderItemStoreRepository.modifyState(tableId,orderids,delivered);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sikeres lekérdezés",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = OrderItemsState.class))) }),
    })
    @Operation(summary = "Rendelések státuszai")
    @GetMapping(path = "/ordersstatuses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderItemsState> ordersStatuses(
            @Parameter(description = "Asztal id-je", required = true) @RequestBody(required = true) String tableId) throws Exception {
        return orderItemStoreRepository.getAll(tableId);
    }







}
