package com.lucio.asyncevents.service.impl;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lucio.asyncevents.event.OrderCreatedEvent;
import com.lucio.asyncevents.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Async
	@EventListener
	public void integratePaymentGateway(OrderCreatedEvent orderCreatedEvent) {
		try {
			log.info(String.format("integratePaymentHateway start %s", orderCreatedEvent));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		log.info(String.format("integratePaymentHateway finished %s", orderCreatedEvent));
	}

	@Async
	@EventListener
	public void sendEmailOrderCreated(OrderCreatedEvent orderCreatedEvent) {
		try {
			log.info(String.format("sendEmailOrderCreated start %s", orderCreatedEvent));
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		log.info(String.format("sendEmailOrderCreated finished %s", orderCreatedEvent));
	}

}
