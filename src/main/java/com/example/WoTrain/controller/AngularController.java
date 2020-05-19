package com.example.WoTrain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AngularController {
    @PostMapping("/angular")
    List<String> returnJsonForAngularExample(@RequestBody Map<String,String> str){

        return new ArrayList<String>(Arrays.asList(str.toString(),"Meow", "My object example"));
    }
}
