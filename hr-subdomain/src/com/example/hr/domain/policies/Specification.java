package com.example.hr.domain.policies;

public interface Specification<T> {
	boolean isSatifiedBy(T t);	
}
