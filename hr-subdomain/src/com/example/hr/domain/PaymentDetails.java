package com.example.hr.domain;

import com.example.helper.ddd.ValueObject;

@ValueObject
public record PaymentDetails(Iban iban,Country country) {
}
