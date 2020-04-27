package com.example.WoTrain.controller;

import com.example.WoTrain.entity.POJORequest.RZDRequest;
import com.example.WoTrain.entity.POJOResponse.RZDResponse;
import com.example.WoTrain.service.classInplement.RZDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class RZDTicketController {

    private final RZDService rzdService;

    @PostMapping("RZD")
    public ResponseEntity<List<RZDResponse>> findTicketsRZD(RZDRequest rzdRequest){
        return ResponseEntity.ok(rzdService.getResponse(rzdRequest));
    }
}
