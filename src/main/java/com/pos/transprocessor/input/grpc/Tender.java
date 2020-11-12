package com.pos.transprocessor.input.grpc;

import com.pos.transcore.bean.TotalMoney;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Tender {
    private String type;
    private String name;
    private TotalMoney totalMoney;
}
