package com.pos.transprocessor.input.grpc;

import com.pos.transcore.bean.AppliedMoney;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Tax {
    private String id;
    private String name;
    private double rate;
    private String inclusionType;
    private Boolean isCustomAmount;
    private AppliedMoney appliedMoney;
}
