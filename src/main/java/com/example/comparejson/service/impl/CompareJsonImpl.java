package com.example.comparejson.service.impl;

import com.example.comparejson.model.Difference;
import com.example.comparejson.model.Product;
import com.example.comparejson.service.CompareJson;
import com.example.comparejson.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Nabeel Bhatti
 */
@Service
public class CompareJsonImpl  implements CompareJson {


    public  void compare(List<Product> productListA, List<Product> productListB) throws JsonProcessingException {
        Difference difference = new Difference();
        List<Product> noMatch = new ArrayList<>();
        if(productListA.size() != productListB.size()){
            difference.setSize(Math.abs(productListA.size()-productListB.size()));
        }
        if(productListA.equals(productListB)){
            difference.getProducts().add(Map.of("matched",productListA ));
            Utils.writeReport(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(difference));
            return;
        }
        List<Product> matched = productListA.stream().filter(product -> {
            if (productListB.contains(product)) {
                return true;
            } else {
                noMatch.add(product);
                return false;
            }
        }).toList();
        difference.setProducts(new ArrayList<>());
        difference.getProducts().add(Map.of("matched", matched));
        difference.getProducts().add(Map.of("different", noMatch));
       Utils.writeReport(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(difference));
    }
}
