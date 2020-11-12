package com.pos.transprocessor.handler;

import com.pos.transcore.bean.*;
import com.pos.transprocessor.JaxbUtils;
import com.pos.transprocessor.input.json.ItemizationType;
import com.pos.transprocessor.input.json.RootType;
import com.pos.transprocessor.input.json.TaxesType;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handler for transactions passed through Json.
 */
public class JsonHandler extends TransactionHandlerImpl<InputStream> {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Unmarshaller unmarshaller;

    {
        unmarshaller = JaxbUtils.createJaxbUnmarshaller(RootType.class, getJaxbUnmarshallerProps());
    }


    @Override
    public Transaction extract(InputStream inputStream) {
        RootType root = null;
        try {
            root = unmarshaller.unmarshal(new StreamSource(inputStream), RootType.class)
                    .getValue();
        } catch (JAXBException e) {
            logger.error("Failed to unmarshal json input stream", e);
            throw new IllegalArgumentException("Failed to parse json input", e);
        }
        return map(root);
    }


    protected Transaction map(RootType root) {
        Transaction trans = new Transaction();
        trans.setId(root.getId());
        trans.setBusinessId(root.getBusinessId());
        trans.setCreationTime(root.getCreationTime().toGregorianCalendar().getTime());
        trans.setDiningOption(root.getDiningOption());
        trans.setItemization(root.getItemization().stream().map(i -> map(i)).collect(Collectors.toList()));
        trans.setLocationId(root.getLocationId());
        trans.setReceiptId(root.getReceiptId());
        trans.setTaxes(map(root.getTaxes()));
        trans.setTransactionId(root.getTransactionId());
        return trans;
    }

    private List<Tax> map(List<TaxesType> taxes) {
        return taxes.stream().map(tax -> {
            Tax t = new Tax();
            AppliedMoney appliedMoney = new AppliedMoney();
            appliedMoney.setAmount(tax.getAppliedMoney().getAmount());
            appliedMoney.setCurrency(tax.getAppliedMoney().getCurrency());
            t.setAppliedMoney(appliedMoney);
            t.setId(tax.getId());
            t.setInclusionType(tax.getInclusionType());
            t.setIsCustomAmount(Boolean.parseBoolean(tax.getIsCustomAmount()));
            return t;
        }).collect(Collectors.toList());
    }


    private Itemization map(ItemizationType itemizationT) {
        Itemization i = new Itemization();
        Category c = new Category();
        c.setId(itemizationT.getId());
        c.setName(itemizationT.getName());
        i.setCategory(c);
        i.setTaxes(map(itemizationT.getTaxes()));
        NetSalesMoney netSalesMoney = new NetSalesMoney();
        netSalesMoney.setAmount(itemizationT.getNetSalesMoney().getAmount());
        netSalesMoney.setCurrency(itemizationT.getNetSalesMoney().getCurrency());
        i.setNetSalesMoney(netSalesMoney);
        TotalMoney totalMoney = new TotalMoney();
        totalMoney.setCurrency(itemizationT.getTotalMoney().getCurrency());
        totalMoney.setAmount(itemizationT.getTotalMoney().getAmount());
        i.setTotalMoney(totalMoney);
        return i;
    }

    private Map<String, Object> getJaxbUnmarshallerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put("eclipselink.media-type", "application/json");
        props.put(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
        return props;
    }
}
