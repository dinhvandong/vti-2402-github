package com.vti.loship.services;

import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Order;
import com.vti.loship.models.OrderDetail;
import com.vti.loship.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIpm implements OrderService
{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @Override
    public Order create(Order newOrder) {
        Long id = sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME);
        newOrder.setId(id);
        return orderRepository.insert(newOrder);
    }

    @Override
    public Order update(Order updateOrder) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        if(optional.isEmpty()){
            return false;
        }
        Order foundOrder = optional.get();
        foundOrder.setStatus(-1);
        orderRepository.save(foundOrder);
        return true;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findAllOrderCancel() {
        return orderRepository.findAllByStatus(-1);
    }

    @Override
    public List<Order> findAllOrderPending() {
        return orderRepository.findAllByStatus(0);
    }

    @Override
    public List<Order> findAllOrderComplete() {
        return orderRepository.findAllByStatus(1);
    }

    @Override
    public List<OrderDetail> findAllByOrderId(Long orderID) {
        Optional<Order> optional = orderRepository.findById(orderID);
        if(optional.isEmpty()){
            return null;
        }
        Order foundOrder = optional.get();
        return foundOrder.getOrderDetailList();
    }

    @Override
    public List<Order> findAllOrderBetweenDate(Long startDate, Long endDate) {



        return null;
    }

    @Override
    public Page<Order> getOrdersByStatusAndSortByCreatedDateDesc
            (int status, int page, int size)
    {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdDate").descending());
        return orderRepository.findByStatusOrderByCreatedDateDesc(status, pageRequest);
    }
}
