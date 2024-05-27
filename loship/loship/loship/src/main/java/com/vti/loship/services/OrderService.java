package com.vti.loship.services;

import com.vti.loship.models.Order;
import com.vti.loship.models.OrderDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    public Order create(Order newOrder);
    public Order update(Order updateOrder);
    public boolean delete(Long id);
    public List<Order> findAll();
    public List<Order> findAllOrderCancel();
    public List<Order> findAllOrderPending();
    public List<Order> findAllOrderComplete();
    public List<OrderDetail> findAllByOrderId(Long orderID);

    public Page<Order> getOrdersByStatusAndSortByCreatedDateDesc(int status, int page, int size);


}
