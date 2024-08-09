package com.objectmapping.runner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;


public class ObjectMapperDemo {
    public static void main(String[] args) {

//        String json = "[{\"brand\":\"Abc\", \"model\":\"123\", \"serial\":\"23801nd\"},"
//                + "{\"brand\":\"Abc\", \"model\":\"123\", \"serial\":\"23801nd\"}]";
//        ObjectMapper mapper = new ObjectMapper();
////        try {
////            Laptop[] l = mapper.readValue(json, Laptop[].class);
////            for(Laptop lt : l){
////                System.out.println(lt);
////            }
//        try {
//            List<Map<String, String>> l = mapper.readValue(json, new TypeReference<List<Map<String, String>>>() {
//            });
//            for (Map<String, String> map : l) {
//                map.keySet().forEach(key -> {
//                    System.out.println("Key " + key);
//                    System.out.println("Value " + map.get(key));
//                });
//            }
//
//        }catch (JsonMappingException e){
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        Laptop l = new Laptop();
        l.setBrand("Hp");
        l.setModel("iPhone");
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, l);
            String json = writer.toString();
            System.out.println(json);
        }catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
@JsonIgnoreProperties(ignoreUnknown = true)
class Laptop {
    private String brand;
    private String model;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
