package com.pos.transprocessor.input.grpc;

import com.pos.transcore.bean.AdditiveTaxMoney;
import com.pos.transcore.bean.Creator;
import com.pos.transcore.bean.DiscountMoney;
import com.pos.transcore.bean.InclusiveTaxMoney;
import com.pos.transcore.bean.Itemization;
import com.pos.transcore.bean.RefundedMoney;
import com.pos.transcore.bean.Tax;
import com.pos.transcore.bean.TaxMoney;
import com.pos.transcore.bean.Tender;
import com.pos.transcore.bean.TipMoney;
import com.pos.transcore.bean.TotalCollectedMoney;
import com.pos.transcore.validation.TransactionConstraint;
import lombok.Data;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Valid
@TransactionConstraint
public class Transaction {

    @Valid
    @NotEmpty
    private String id; //TODO update fields names with _
    private String businessId; // TODO update instance variables to private
    private String locationId;
    private String transactionId;
    private String receiptId;
    private String serialNumber;
    private String diningOption;
    private Date creationTime;
    private DiscountMoney discountMoney;
    private AdditiveTaxMoney additiveTaxMoney;
    private InclusiveTaxMoney inclusiveTaxMoney;
    private RefundedMoney refundedMoney;
    private TaxMoney taxMoney;
    private TipMoney tipMoney;
    private TotalCollectedMoney totalCollectedMoney;
    private Creator creator;
    private Tender tender;
    private List<Tax> taxes;
    private List<Itemization> itemization;
}
