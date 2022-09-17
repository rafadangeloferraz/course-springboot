package com.duquesantana.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duquesantana.course.entities.Order;

// nossos repositories serao interfaces pq o JpaRepository eh interface tb, 
public interface OrderRepository extends JpaRepository<Order, Long> {
//nao precisa criar implementacao da interface pq o spring data jpa jah tem implementacao padrao para essa interface
}
