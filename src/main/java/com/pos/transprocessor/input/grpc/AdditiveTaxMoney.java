package com.pos.transprocessor.input.grpc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class AdditiveTaxMoney {
    private double amount;
    private String currency;
}
