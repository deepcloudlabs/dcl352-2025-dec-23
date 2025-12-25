package com.example.hr.service;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Component
@Inherited
public @interface WebSocketController {

}
