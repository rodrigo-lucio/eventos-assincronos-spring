package com.lucio.asyncevents.service;

import com.lucio.asyncevents.event.OrderCreatedEvent;

public interface OrderService {

	void sendEmailOrderCreated(OrderCreatedEvent orderCreatedEvent);
	void integratePaymentHateway(OrderCreatedEvent orderCreatedEvent);
	
}
