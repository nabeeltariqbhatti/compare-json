package com.example.comparejson;

import com.example.comparejson.model.Product;
import com.example.comparejson.service.CompareJson;
import com.example.comparejson.service.impl.Others;
import com.example.comparejson.util.Mapper;
import com.example.comparejson.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class CompareJsonApplication implements CommandLineRunner {

    @Autowired
    private Utils utils;
    @Autowired
    private CompareJson compareJson;
    @Autowired
    private Others others;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired private Mapper mapper;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(CompareJsonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final  var stringA = "src/main/resources/productsA.json";
        final var stringB = "src/main/resources/productsB.json";
//        List<Product> listA = utils.mapper("src/main/resources/productsA.json");
//        List<Product> listB = utils.mapper("src/main/resources/productsB.json");
//        compareJson.compare(listA,listB);

//        others.compareUsingJsonNode(objectMapper.readTree(Path.of(stringA).toFile()),
//               objectMapper.readTree(Path.of(stringA).toFile()));

        System.out.println(mapper.fromJson(Files.readString(Path.of("src/main/resources/NodeA.json")), Product.class));
       // others.compareJsonFiles("src/main/resources/NodeA.json","src/main/resources/NodeB.json","src/main/resources/report.json");
    }


}
