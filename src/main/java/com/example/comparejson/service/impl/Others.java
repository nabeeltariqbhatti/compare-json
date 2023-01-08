package com.example.comparejson.service.impl;

import com.example.comparejson.model.Difference;
import com.example.comparejson.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nabeel Bhatti
 */
@Service
public class Others {

    @Autowired
    private ObjectMapper objectMapper;

    public void compareUsingJsonNode(JsonNode jsonNodeA, JsonNode jsonNodeB) throws JsonProcessingException {
        /**
         * we can compare two files directly
         * preferred way
         */

//        JsonNode jsonNode1 = JsonDiff.asJson(jsonNodeA, jsonNodeB);
//        if(jsonNode1!=null){
//            if(!jsonNode1.toPrettyString().equals("[]")){
//                Utils.writeReport(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode1));
//            }
//            return;
//        }

        if(jsonNodeA.equals(jsonNodeB)){
            System.out.println("completely matched ");
            Utils.writeReport(" 100% matched");
            return;
        }
        Difference difference = new Difference();
        if(jsonNodeA.size() != jsonNodeB.size()){
            difference.setSize(Math.abs(jsonNodeA.size()-jsonNodeB.size()));
        }
        List<JsonNode> matched = new ArrayList<>();
        List<JsonNode> notMatched = new ArrayList<>();
        for (JsonNode jsonNode : jsonNodeA) {
            boolean flagMatched = false;
            for (JsonNode node : jsonNodeB) {
                if(jsonNode.equals(node)){
                    flagMatched = true;
                    matched.add(jsonNode);
                    break;
                }
            }
            if(!flagMatched){
                notMatched.add(jsonNode);
            }
        }
        difference.setProducts(new ArrayList<>());
        difference.getProducts().add(Map.of("matched", matched));
        difference.getProducts().add(Map.of("not-matched", notMatched));
        Utils.writeReport(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(difference));
    }

    /**
     * compare two json objects by using org.json
     * read json objects and create an JsonArray after that iterate through all the array objects and
     * compare them by using keys and values
     * @param file1
     * @param file2
     * @param outputFile
     */
    public void compareJsonFiles(String file1, String file2, String outputFile) {
        try {
            // Read the contents of the two files
            String jsonString1 = Files.readString(Paths.get(file1));
            String jsonString2 = Files.readString(Paths.get(file2));

            // Convert the contents to JSON objects
            JSONObject json1 = new JSONObject(jsonString1);
            JSONObject json2 = new JSONObject(jsonString2);
            // Compare the JSON objects and get the difference
            JSONObject difference = new JSONObject();
            for (String key : json1.keySet()) {
                if (!json1.get(key).equals(json2.get(key))) {
                    difference.put(key, json2.get(key));
                }
            }
            // Write the difference to the output file
            Path outputPath = Paths.get(outputFile);
            Files.writeString(outputPath, difference.toString(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
