package com.lucio.asyncevents.event;

import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResourceEventCreated<K, T> {

	private K id;
	private T resource;
	private HttpServletResponse response;
	
}
