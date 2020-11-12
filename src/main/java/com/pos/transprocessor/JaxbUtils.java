package com.pos.transprocessor;

import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for Jaxb context
 */
public class JaxbUtils {

    /**
     * Creates a Jaxb unmarshaller object
     * @param jaxbRoot - Root class used for jaxb initialization
     * @param unmarshallerProps - unmarshaller props
     * @return unmarshaller object
     */
    public static Unmarshaller createJaxbUnmarshaller(Class jaxbRoot,
                                                      Map<String, Object> unmarshallerProps) {
        Unmarshaller unmarshaller;
        try {
            unmarshaller = initializeJaxbContext(jaxbRoot, unmarshallerProps);
        } catch (JAXBException e) {
            LoggerFactory.getLogger(JaxbUtils.class).error("Failed to initialize Jaxb context", e);
            throw new IllegalStateException("Failed to initialize Jaxb unmarshaller");
        }
        return unmarshaller;
    }


    private static Unmarshaller initializeJaxbContext(Class jaxbRoot, Map<String, Object> unmarshallerProps) throws JAXBException {
        Map<String, Object> properties = new HashMap<>(1);
        System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
        JAXBContext jc = JAXBContext.newInstance(new Class[]{jaxbRoot}, properties);

        // Create the Unmarshaller Object using the JaxB Context
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        addUnmarshallerProps(unmarshaller, unmarshallerProps);

        return unmarshaller;
    }

    private static void addUnmarshallerProps(Unmarshaller unmarshaller, Map<String, Object> unmarshallerProps) {
        if (!CollectionUtils.isEmpty(unmarshallerProps)) {
            unmarshallerProps.entrySet().stream().forEach(e -> {
                try {
                    unmarshaller.setProperty(e.getKey(), e.getValue());
                } catch (PropertyException propertyException) {
                    throw new IllegalStateException(propertyException);
                }
            });
        }
    }
}
