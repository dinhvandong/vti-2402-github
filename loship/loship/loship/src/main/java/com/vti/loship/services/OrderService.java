package com.vti.loship.services;

import com.vti.loship.models.Order;
import com.vti.loship.models.OrderDetail;
import com.vti.loship.models.Product;
import com.vti.loship.models.ProductGroup;
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

 //=========================================================================================
    // 1.  DUONG - HUNGW
    public List<Order> findAllOrderBetweenDate(Long startDate, Long endDate);

    // 2. HUYNH
    public List<Order> findAllByDate(Long dateValue);

// 3. CHINH - DUC CHIEN -
    public List<ProductGroup> findTop10ProductGroup(Long startDate, Long endDate);

// 4. TRINH - DUC PHAN
    public List<Product> findTop20Product(Long startDate, Long endDate);

//==========================================================================================
    public Page<Order> getOrdersByStatusAndSortByCreatedDateDesc(int status, int page, int size);


}
