package com.example.WoTrain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AngularController {
    @GetMapping("/angular")
    List<Integer> returnJsonForAngularExample(){
        return new ArrayList<>(Arrays.asList(1,2,3,4,5));
    }
}
