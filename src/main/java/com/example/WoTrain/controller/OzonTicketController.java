package com.example.WoTrain.controller;

import com.example.WoTrain.entity.POJORequest.OzonRequest;
import com.example.WoTrain.entity.POJOResponse.OzonResponse;
import com.example.WoTrain.service.classInplement.OzonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class OzonTicketController {

    private final OzonService ozonService;

    @PostMapping("Ozon")
    public ResponseEntity<List<OzonResponse>> findTicketsOzon(OzonRequest ozonRequest){
        return ResponseEntity.ok(ozonService.getResponse(ozonRequest));
    }
}
