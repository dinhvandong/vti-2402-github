package com.vti.loship.repositories;

import com.vti.loship.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long>
{

    public List<Order> findAllByStatus(int status);

    Page<Order> findByStatusOrderByCreatedDateDesc(int status, Pageable pageable);



}
