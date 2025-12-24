package com.example.hr.infrastructure;

import com.example.helper.hexagonal.Port;
import com.example.helper.hexagonal.PortType;

@Port(PortType.DRIVEN)
public interface EventPublisher<E> {
	void publish(E e);	
}
