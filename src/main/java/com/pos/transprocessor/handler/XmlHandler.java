package com.pos.transprocessor.handler;

import com.pos.transcore.bean.*;
import com.pos.transprocessor.JaxbUtils;
import com.pos.transprocessor.input.xml.ElementType;
import com.pos.transprocessor.input.xml.ItemizationType;
import com.pos.transprocessor.input.xml.RootType;
import com.pos.transprocessor.input.xml.TaxesType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handler for transactions passed through xml.
 */
public class XmlHandler extends TransactionHandlerImpl<InputStream> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Unmarshaller unmarshaller;

    {
        unmarshaller = JaxbUtils.createJaxbUnmarshaller(RootType.class, null);
    }


    /**
     * {@inheritDoc}
     *
     * @param inputStream - XML input stream
     * @return <code>Transaction</code> DTO object
     */
    @Override
    public Transaction extract(InputStream inputStream) {
        RootType root;
        try {
            root = unmarshaller.unmarshal(new StreamSource(inputStream), RootType.class)
                    .getValue();
        } catch (JAXBException e) {
            logger.error("Failed to unmarshal xml input stream", e);
            throw new IllegalArgumentException("Failed to parse xml input", e);
        }
        return map(root);
    }


    protected Transaction map(RootType root) {
        Transaction trans = new Transaction();
        trans.setId(root.getId());
        trans.setBusinessId(root.getBusinessId());
        trans.setCreationTime(root.getCreationTime().toGregorianCalendar().getTime());
        trans.setDiningOption(root.getDiningOption());
        trans.setItemization(root.getItemization().stream().map(this::map).collect(Collectors.toList()));
        trans.setLocationId(root.getLocationId());
        trans.setReceiptId(root.getReceiptId());
        trans.setTaxes(map(root.getTaxes()));
        trans.setTransactionId(root.getTransactionId());
        return trans;
    }

    private List<Tax> map(List<TaxesType> taxes) {
        return taxes.stream().map(tax -> {
            Tax t = new Tax();
            AppliedMoney appliedMoney = tax.getElement().stream().findFirst().map(e -> {
                AppliedMoney money = new AppliedMoney();
                money.setAmount(e.getAppliedMoney().getAmount());
                money.setCurrency(e.getAppliedMoney().getCurrency());
                return money;
            }).orElse(null);

            t.setAppliedMoney(appliedMoney);
            ElementType elementType = tax.getElement().stream().findFirst().orElse(new ElementType());
            t.setId(elementType.getId());
            t.setInclusionType(elementType.getInclusionType());
            t.setIsCustomAmount(Boolean.parseBoolean(elementType.getIsCustomAmount()));
            return t;
        }).collect(Collectors.toList());
    }


    private Itemization map(ItemizationType itemizationT) {
        Itemization i = new Itemization();
        Category c = new Category();
        c.setId(itemizationT.getElement().getId());
        c.setName(itemizationT.getElement().getName());
        i.setCategory(c);
        i.setTaxes(map(itemizationT.getElement().getTaxes()));
        NetSalesMoney netSalesMoney = new NetSalesMoney();
        netSalesMoney.setAmount(itemizationT.getElement().getNetSalesMoney().getAmount());
        netSalesMoney.setCurrency(itemizationT.getElement().getNetSalesMoney().getCurrency());
        i.setNetSalesMoney(netSalesMoney);
        TotalMoney totalMoney = new TotalMoney();
        totalMoney.setCurrency(itemizationT.getElement().getTotalMoney().getCurrency());
        totalMoney.setAmount(itemizationT.getElement().getTotalMoney().getAmount());
        i.setTotalMoney(totalMoney);
        return i;
    }

}
