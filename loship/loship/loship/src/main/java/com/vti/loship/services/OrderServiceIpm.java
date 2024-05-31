package com.vti.loship.services;

import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Order;
import com.vti.loship.models.OrderDetail;
import com.vti.loship.models.Product;
import com.vti.loship.models.ProductGroup;
import com.vti.loship.repositories.OrderRepository;
import com.vti.loship.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceIpm implements OrderService
{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    ProductRepository productRepository;


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

        return orderRepository.findOrdersBetweenDates(startDate, endDate);
    }

    @Override
    public List<Order> findAllByDate(Long dateValue) {
        return orderRepository.findAllByCreatedDate(dateValue);
    }

    @Override
    public List<ProductGroup> findTop10ProductGroup(Long startDate, Long endDate) {
        return null;
    }

    @Override
    public List<Product> findTop20Product(Long startDate, Long endDate) {

        List<Order> orderList = orderRepository.findOrdersBetweenDates(startDate, endDate);
        List<Long> productIds = new ArrayList<Long>();

        for(Order order: orderList){

            for(OrderDetail orderDetail: order.getOrderDetailList()){

                productIds.add(orderDetail.getProductID());
            }
        }
        // 1,1,1,2,2,2,2,3,3,3,3,4,4,5,5,54,6,5,5,5,6,67,7,78,8,8,8,9,9,2,32,23,32,2,23,34,324,432
        Map<Long, Integer> productCounts = new HashMap<>();
        for (Long productId : productIds) {
            productCounts.
                    put(productId, productCounts.getOrDefault(productId, 0) + 1);
        }
        // Sort product IDs by count and retrieve top 20
        List<Long> topProductIds = productCounts.entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .limit(
                        20
                )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<Product> returnList = new ArrayList<>();

        for(Long idProduct: topProductIds) {
            Optional<Product> pOptional = productRepository.findById(idProduct);
            if(pOptional.isPresent()) {
                returnList.add(pOptional.get());
            }
        }
        return  returnList;

}





    @Override
    public Page<Order> getOrdersByStatusAndSortByCreatedDateDesc
            (int status, int page, int size)
    {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdDate").descending());
        return orderRepository.findByStatusOrderByCreatedDateDesc(status, pageRequest);
    }
}
