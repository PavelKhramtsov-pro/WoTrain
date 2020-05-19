package com.example.WoTrain.controller;

import com.example.WoTrain.entity.POJORequest.OzonRequest;
import com.example.WoTrain.entity.POJOResponse.OzonResponse;
import com.example.WoTrain.service.classInplement.OzonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
@Log4j2
public class OzonTicketController {

    private final OzonService ozonService;

    @PostMapping("Ozon")
    public ResponseEntity<List<OzonResponse>> findTicketsOzon(@RequestBody OzonRequest ozonRequest){
        log.error(ozonRequest);
        return ResponseEntity.ok(ozonService.getResponse(ozonRequest));
    }
}
