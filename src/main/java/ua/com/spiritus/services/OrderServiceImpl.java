package ua.com.spiritus.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.spiritus.models.Order;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.OrderRepository;

import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private UserService userService;
    private AlbumItemService albumItemService;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAlbumItemService(AlbumItemService albumItemService) {
        this.albumItemService = albumItemService;}

    @Override
    public boolean saveOrder(Integer userId, Order order) {
        boolean saved = false;
        User user = userService.findById(userId);
        if (user!=null){
            order.setUser(user);
            order.setOrderDate(LocalDateTime.now());

            orderRepository.save(order);
            saved=true;
        }
        else{
            log.warn("User with id " + userId + " not found");
        }
        return saved;
    }
}
