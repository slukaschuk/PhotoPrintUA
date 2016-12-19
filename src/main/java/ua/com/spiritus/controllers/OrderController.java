package ua.com.spiritus.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.spiritus.models.Order;
import ua.com.spiritus.services.OrderService;

@RestController
@Slf4j
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    //-------------------Create a order for user--------------------------------------------------------
    @RequestMapping(value = "/user/{userid}/order/", method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@PathVariable("userid") Integer userId, @RequestBody Order order) {
        boolean created = orderService.saveOrder(userId, order);
        if (created) {
            log.info("Order for user with id " + userId + " was created with id" + order.getOrderId());
            return new ResponseEntity<Order>(order, HttpStatus.CREATED);
        } else {
            log.info("Order for user with id " + userId + " wasn't created!");
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }

}
