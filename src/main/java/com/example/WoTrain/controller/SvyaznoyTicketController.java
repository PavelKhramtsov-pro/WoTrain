package com.example.WoTrain.controller;

import com.example.WoTrain.entity.POJORequest.SvyaznoyRequest;
import com.example.WoTrain.entity.POJOResponse.SvyaznoyResponse;
import com.example.WoTrain.service.classInplement.SvyaznoyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class SvyaznoyTicketController {

    private final SvyaznoyService svyaznoyService;

    @PostMapping("Svyaznoy")
    public ResponseEntity<List<SvyaznoyResponse>> findTicketsSvyaznoy(@RequestBody SvyaznoyRequest svyaznoyRequest){
        return ResponseEntity.ok(svyaznoyService.getResponse(svyaznoyRequest));
    }

}
