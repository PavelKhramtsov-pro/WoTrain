package com.example.WoTrain.service.classInplement;

import com.example.WoTrain.entity.POJORequest.Request;
import com.example.WoTrain.entity.POJORequest.SvyaznoyRequest;
import com.example.WoTrain.entity.POJOResponse.SvyaznoyResponse;
import com.example.WoTrain.service.intefaces.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
@Log4j2
public  class SvyaznoyService implements TicketService<SvyaznoyResponse,SvyaznoyRequest> {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${service.svyaznoy}")
    String URLSvyaznoy;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<SvyaznoyResponse> getResponse( SvyaznoyRequest request) {

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        String response = restTemplate
                .exchange(URLSvyaznoy, HttpMethod.POST,httpEntity,String.class)
                .getBody();
        List<SvyaznoyResponse> svyaznoyResponses = new ArrayList<>();
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode trains = jsonNode.findValue("trains");


            for (int i = 0; i < trains.size(); i++) {

                //SvyaznoyResponse svyaznoyResponse = objectMapper.readValue(trains.get(i).toString(), SvyaznoyResponse.class);
                SvyaznoyResponse svyaznoyResponse = new SvyaznoyResponse();
                JsonNode train = trains.get(i);
                List<SvyaznoyResponse.Coupe> listCope = new ArrayList<>();
                svyaznoyResponse.setCodeArrival(train.findValue("stations").findValue("depart").findValue("code").toString());
                svyaznoyResponse.setCodeDepart(train.findValue("stations").findValue("arrival").findValue("code").toString());
                svyaznoyResponse.setDateFrom(train.findValue("dateFrom").toString());
                svyaznoyResponse.setDateTo(train.findValue("dateTo").toString());
                svyaznoyResponse.setTimeFrom(train.findValue("timeFrom").toString());
                svyaznoyResponse.setTimeTo(train.findValue("timeTo").toString());
                svyaznoyResponse.setTrainNum(train.findValue("trainNum").toString());
                for (JsonNode node:train.findValue("coupes")) {
                    SvyaznoyResponse.Coupe coupe =  svyaznoyResponse.new Coupe();
                    //SvyaznoyResponse.Coupe coupe = objectMapper.readValue(node.get(0).toString(), SvyaznoyResponse.Coupe.class);
                    coupe.setPlaces(node.findValue("places").toString());
                    coupe.setType(node.findValues("type").get(1).toString());
                    coupe.setPrice(node.findValue("price").toString());
                    coupe.setMaxPrice(node.findValue("maxPrice").toString());
                    listCope.add(coupe);
                }
                svyaznoyResponse.setCoupes(listCope);
                svyaznoyResponses.add(svyaznoyResponse);

            }
            log.error(svyaznoyResponses.get(0));
        } catch (JsonProcessingException e) {
            log.error("Error when parsing Ozon Travel response", e);
        }
        //log.error(response);
        return svyaznoyResponses;
    }
}