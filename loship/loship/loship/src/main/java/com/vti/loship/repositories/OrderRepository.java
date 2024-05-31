package com.vti.loship.repositories;

import com.vti.loship.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long>
{


    public List<Order> findAllByCreatedDate(Long createdDate);
    public List<Order> findAllByStatus(int status);
    @Query("{ 'createdDate' : { $gte: ?0, $lte: ?1 } }")
    List<Order> findOrdersBetweenDates(Long startDate, Long endDate);
    Page<Order> findByStatusOrderByCreatedDateDesc(int status, Pageable pageable);





}
