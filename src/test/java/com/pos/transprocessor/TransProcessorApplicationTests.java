package com.pos.transprocessor;

import com.pos.transprocessor.handler.JsonHandler;
import com.pos.transprocessor.handler.XmlHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class TransProcessorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJson() {
        String json = "{\n" +
                "    \"_id\" : \"589c493e5f2687111bb6d800\",\n" +
                "    \"business_id\" : \"3f522ee8-7e69-4d78-aeb5-5278aaf21558\",\n" +
                "    \"location_id\" : \"96e9975b-b1bf-47ee-aeaf-63518022e95e\",\n" +
                "    \"transaction_id\" : \"37a5f57a-48bc-483d-91b7-88c8b1b9509c\",\n" +
                "    \"receipt_id\" : \"Cj9uohMQNVflSq7taYtVRk\",\n" +
                "    \"serial_number\" : \"C1-498\",\n" +
                "    \"dining_option\" : \"In-House\",\n" +
                "    \"creation_time\" : \"2017-02-09T10:49:34.000Z\",\n" +
                "    \"discount_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"additive_tax_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"inclusive_tax_money\" : {\n" +
                "        \"amount\" : 483,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"refunded_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"tax_money\" : {\n" +
                "        \"amount\" : 483,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"tip_money\" : {\n" +
                "        \"amount\" : 0,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"total_collected_money\" : {\n" +
                "        \"amount\" : 3500,\n" +
                "        \"currency\" : \"JOD\"\n" +
                "    },\n" +
                "    \"creator\" : {\n" +
                "        \"id\" : \"00000000-0000-0000-0000-000000000000\",\n" +
                "        \"name\" : \"John Doe\",\n" +
                "        \"email\" : \"anonymous@example.com\"\n" +
                "    },\n" +
                "    \"tender\" : {\n" +
                "        \"type\" : \"CASH\",\n" +
                "        \"name\" : \"CASH\",\n" +
                "        \"total_money\" : {\n" +
                "            \"amount\" : 3500,\n" +
                "            \"currency\" : \"JOD\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"taxes\" : [ \n" +
                "        {\n" +
                "            \"id\" : \"cfc92a12-f847-4942-b6ec-1454d194c9ba\",\n" +
                "            \"name\" : \"Sales Tax\",\n" +
                "            \"rate\" : 0.16,\n" +
                "            \"inclusion_type\" : \"INCLUSIVE\",\n" +
                "            \"is_custom_amount\" : true,\n" +
                "            \"applied_money\" : {\n" +
                "                \"amount\" : 483,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"itemization\" : [ \n" +
                "        {\n" +
                "            \"id\" : \"788cb9cb-106f-4d32-ac48-df9e8433ff50\",\n" +
                "            \"name\" : \"Boneless Chicken Wings\",\n" +
                "            \"quantity\" : 1,\n" +
                "            \"total_money\" : {\n" +
                "                \"amount\" : 3500,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"single_quantity_money\" : {\n" +
                "                \"amount\" : 3500,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"gross_sales_money\" : {\n" +
                "                \"amount\" : 3017,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"discount_money\" : {\n" +
                "                \"amount\" : 0,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"net_sales_money\" : {\n" +
                "                \"amount\" : 3017,\n" +
                "                \"currency\" : \"JOD\"\n" +
                "            },\n" +
                "            \"category\" : {\n" +
                "                \"id\" : \"a9895c94-15cc-4db1-bbad-fe62d218c931\",\n" +
                "                \"name\" : \"Appetizers\"\n" +
                "            },\n" +
                "            \"variation\" : {\n" +
                "                \"id\" : \"37b64192-6b0f-479d-aeee-3c382a0671b9\",\n" +
                "                \"name\" : \"Plate\",\n" +
                "                \"pricing_type\" : \"FIXED\",\n" +
                "                \"price_money\" : {\n" +
                "                    \"amount\" : 3500,\n" +
                "                    \"currency\" : \"JOD\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"taxes\" : [ \n" +
                "                {\n" +
                "                    \"id\" : \"cfc92a12-f847-4942-b6ec-1454d194c9ba\",\n" +
                "                    \"name\" : \"Sales Tax\",\n" +
                "                    \"rate\" : 0.16,\n" +
                "                    \"inclusion_type\" : \"INCLUSIVE\",\n" +
                "                    \"is_custom_amount\" : true,\n" +
                "                    \"applied_money\" : {\n" +
                "                        \"amount\" : 483,\n" +
                "                        \"currency\" : \"JOD\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"discounts\" : [],\n" +
                "            \"modifiers\" : [ \n" +
                "                {\n" +
                "                    \"id\" : \"7424ae3d-36bc-4c0c-b790-310614905aed\",\n" +
                "                    \"name\" : \"6 Pieces\",\n" +
                "                    \"quantity\" : 1,\n" +
                "                    \"applied_money\" : {\n" +
                "                        \"amount\" : 0,\n" +
                "                        \"currency\" : \"JOD\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        InputStream targetStream = new ByteArrayInputStream(json.getBytes());
        JsonHandler jsonProcessor = new JsonHandler();
        jsonProcessor.process(targetStream);

    }


    @Test
    public void testXml() {
        String xml = "<?com.pos.transProcessor.xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <_id>589c493e5f2687111bb6d800</_id>\n" +
                "    <additive_tax_money>\n" +
                "        <amount>0.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </additive_tax_money>\n" +
                "    <business_id>3f522ee8-7e69-4d78-aeb5-5278aaf21558</business_id>\n" +
                "    <creation_time>2017-02-09T10:49:34.000Z</creation_time>\n" +
                "    <creator>\n" +
                "        <email>anonymous@example.com</email>\n" +
                "        <id>00000000-0000-0000-0000-000000000000</id>\n" +
                "        <name>John Doe</name>\n" +
                "    </creator>\n" +
                "    <dining_option>In-House</dining_option>\n" +
                "    <discount_money>\n" +
                "        <amount>0.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </discount_money>\n" +
                "    <inclusive_tax_money>\n" +
                "        <amount>483.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </inclusive_tax_money>\n" +
                "    <itemization>\n" +
                "        <element>\n" +
                "            <category>\n" +
                "                <id>a9895c94-15cc-4db1-bbad-fe62d218c931</id>\n" +
                "                <name>Appetizers</name>\n" +
                "            </category>\n" +
                "            <discount_money>\n" +
                "                <amount>0.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </discount_money>\n" +
                "            <discounts />\n" +
                "            <gross_sales_money>\n" +
                "                <amount>3017.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </gross_sales_money>\n" +
                "            <id>788cb9cb-106f-4d32-ac48-df9e8433ff50</id>\n" +
                "            <modifiers>\n" +
                "                <element>\n" +
                "                    <applied_money>\n" +
                "                        <amount>0.0</amount>\n" +
                "                        <currency>JOD</currency>\n" +
                "                    </applied_money>\n" +
                "                    <id>7424ae3d-36bc-4c0c-b790-310614905aed</id>\n" +
                "                    <name>6 Pieces</name>\n" +
                "                    <quantity>1</quantity>\n" +
                "                </element>\n" +
                "            </modifiers>\n" +
                "            <name>Boneless Chicken Wings</name>\n" +
                "            <net_sales_money>\n" +
                "                <amount>3017.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </net_sales_money>\n" +
                "            <quantity>1</quantity>\n" +
                "            <single_quantity_money>\n" +
                "                <amount>3500.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </single_quantity_money>\n" +
                "            <taxes>\n" +
                "                <element>\n" +
                "                    <applied_money>\n" +
                "                        <amount>483.0</amount>\n" +
                "                        <currency>JOD</currency>\n" +
                "                    </applied_money>\n" +
                "                    <id>cfc92a12-f847-4942-b6ec-1454d194c9ba</id>\n" +
                "                    <inclusion_type>INCLUSIVE</inclusion_type>\n" +
                "                    <is_custom_amount>true</is_custom_amount>\n" +
                "                    <name>Sales Tax</name>\n" +
                "                    <rate>0.16</rate>\n" +
                "                </element>\n" +
                "            </taxes>\n" +
                "            <total_money>\n" +
                "                <amount>3500.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </total_money>\n" +
                "            <variation>\n" +
                "                <id>37b64192-6b0f-479d-aeee-3c382a0671b9</id>\n" +
                "                <name>Plate</name>\n" +
                "                <price_money>\n" +
                "                    <amount>3500.0</amount>\n" +
                "                    <currency>JOD</currency>\n" +
                "                </price_money>\n" +
                "                <pricing_type>FIXED</pricing_type>\n" +
                "            </variation>\n" +
                "        </element>\n" +
                "    </itemization>\n" +
                "    <location_id>96e9975b-b1bf-47ee-aeaf-63518022e95e</location_id>\n" +
                "    <receipt_id>Cj9uohMQNVflSq7taYtVRk</receipt_id>\n" +
                "    <refunded_money>\n" +
                "        <amount>0.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </refunded_money>\n" +
                "    <serial_number>C1-498</serial_number>\n" +
                "    <tax_money>\n" +
                "        <amount>483.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </tax_money>\n" +
                "    <taxes>\n" +
                "        <element>\n" +
                "            <applied_money>\n" +
                "                <amount>483.0</amount>\n" +
                "                <currency>JOD</currency>\n" +
                "            </applied_money>\n" +
                "            <id>cfc92a12-f847-4942-b6ec-1454d194c9ba</id>\n" +
                "            <inclusion_type>INCLUSIVE</inclusion_type>\n" +
                "            <is_custom_amount>true</is_custom_amount>\n" +
                "            <name>Sales Tax</name>\n" +
                "            <rate>0.16</rate>\n" +
                "        </element>\n" +
                "    </taxes>\n" +
                "    <tender>\n" +
                "        <name>CASH</name>\n" +
                "        <total_money>\n" +
                "            <amount>3500.0</amount>\n" +
                "            <currency>JOD</currency>\n" +
                "        </total_money>\n" +
                "        <type>CASH</type>\n" +
                "    </tender>\n" +
                "    <tip_money>\n" +
                "        <amount>0.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </tip_money>\n" +
                "    <total_collected_money>\n" +
                "        <amount>3500.0</amount>\n" +
                "        <currency>JOD</currency>\n" +
                "    </total_collected_money>\n" +
                "    <transaction_id>37a5f57a-48bc-483d-91b7-88c8b1b9509c</transaction_id>\n" +
                "</root>";

        InputStream targetStream = new ByteArrayInputStream(xml.getBytes());
        XmlHandler xmlProcessor = new XmlHandler();
        xmlProcessor.process(targetStream);
    }

}
