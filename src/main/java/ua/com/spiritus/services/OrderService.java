package ua.com.spiritus.services;


import ua.com.spiritus.models.Order;

public interface OrderService {
    boolean saveOrder(Integer userId, Order order);
}
