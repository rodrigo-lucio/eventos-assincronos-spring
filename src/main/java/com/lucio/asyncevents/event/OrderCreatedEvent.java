package com.lucio.asyncevents.event;

import javax.servlet.http.HttpServletResponse;

import com.lucio.asyncevents.entity.Order;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderCreatedEvent extends ResourceEventCreated<Long, Order>{

	private Order orderCreated;

	public OrderCreatedEvent(Order orderCreated, HttpServletResponse response) {
		super(orderCreated.getId(), orderCreated, response);
		this.orderCreated = orderCreated;
	}
	
	
}
