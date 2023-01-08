package com.example.comparejson.util;

import com.example.comparejson.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Nabeel Bhatti
 */
@Component
public class Utils {


    @Autowired
    private ObjectMapper objectMapper;
    public List<Product> mapper (String path) throws IOException {
        return objectMapper.readValue(Path.of(path).toFile(), new TypeReference<>() {
        });
    }


   public static void writeReport(String resultString){
        try(final var bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/report.json"))){
            bufferedWriter.write(resultString);
            bufferedWriter.flush();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }


}
