package com.lucio.asyncevents.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucio.asyncevents.entity.Order;
import com.lucio.asyncevents.event.OrderCreatedEvent;
import com.lucio.asyncevents.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private OrderRepository repository;
	
	@GetMapping
	public List<Order> findAll() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order, HttpServletResponse response) {
		Order newOrder = repository.save(order); 
		publisher.publishEvent(new OrderCreatedEvent(order, response));
		return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
	}
	
}
