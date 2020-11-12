package com.pos.transprocessor.input.grpc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@Setter
@NoArgsConstructor
@Valid
public class NetSalesMoney {
    @PositiveOrZero
    private double amount;
    @NotNull
    private String currency;
}
