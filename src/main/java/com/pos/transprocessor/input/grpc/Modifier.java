package com.pos.transprocessor.input.grpc;

import com.pos.transcore.bean.AppliedMoney;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Modifier {
    private String id;
    private String name;
    private int quantity;
    private AppliedMoney appliedMoney;
}
