package com.lucio.asyncevents.event;

import java.net.URI;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ApplicationEventListener<K, T> {

	@EventListener		//Nao fica assíncrono
	public void addHeaderLocation(ResourceEventCreated<K, T> event) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(event.getId()).toUri();
		
		event.getResponse().setHeader("Location", uri.toASCIIString());
	}
}
