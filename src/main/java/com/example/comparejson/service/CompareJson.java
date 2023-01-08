package com.example.comparejson.service;

import com.example.comparejson.model.Difference;
import com.example.comparejson.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nabeel Bhatti
 */

public interface CompareJson{

    public  void compare(List<Product> productListA, List<Product> productListB) throws JsonProcessingException;
}
