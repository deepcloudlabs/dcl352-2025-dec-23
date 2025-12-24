package com.example.hr.domain;

import com.example.ddd.ValueObject;

@ValueObject
public record PaymentDetails(Iban iban,Country country) {
}
