package com.pos.transprocessor.input.grpc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@Data
@Setter
@NoArgsConstructor
public class Itemization {
    private String id;
    private String name;
    private int quantity;
    private TotalMoney totalMoney;
    private SingleQuantityMoney singleQuantityMoney;
    private GrossSalesMoney grossSalesMoney;
    private DiscountMoney discountMoney;
    @NotNull
    private NetSalesMoney netSalesMoney;
    private Category category;
    private Variation variation;
    private List<Tax> taxes;
    private List<Object> discounts;
    private List<Modifier> modifiers;
}
