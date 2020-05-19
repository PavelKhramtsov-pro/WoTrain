package com.example.WoTrain.service.classInplement;

import com.example.WoTrain.entity.POJORequest.OzonRequest;
import com.example.WoTrain.entity.POJORequest.Request;
import com.example.WoTrain.entity.POJOResponse.OzonResponse;
import com.example.WoTrain.service.intefaces.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
@Service
@Log4j2
public class OzonService implements TicketService<OzonResponse,OzonRequest> {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${service.ozon}")
    String URLOzon;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<OzonResponse> getResponse(OzonRequest request) {
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        List<OzonResponse> ozonResponses = new ArrayList<>();
        String response = restTemplate
                .exchange(URLOzon, HttpMethod.POST,httpEntity,String.class)
                .getBody();
        log.error(request);
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            List<JsonNode> segments = jsonNode.findValues("segments");

            List<JsonNode> tariffs = jsonNode.findValues("tariffs");
            for (int i = 0; i < segments.size(); i++) {
                OzonResponse ozonResponse = objectMapper.readValue(segments.get(i).get(0).toString(), OzonResponse.class);
                JsonNode segment = segments.get(i).get(0);
                List<OzonResponse.Tariff> listTariff = new ArrayList<>();
                ozonResponse.setDisplayNumber(segment.findValue("displayNumber").toString());
                ozonResponse.setCodeArrivalStation(segment.findValue("arrivalStation").findValue("code").toString());
                ozonResponse.setCodedepartureStation(segment.findValue("departureStation").findValue("code").toString());
                for (JsonNode node:tariffs.get(i)) {
                    OzonResponse.Tariff tariff =  ozonResponse.new Tariff();
                    tariff.setCategory(node.findValue("category").toString());
                    tariff.setMin(node.findValue("price").findValue("min").toString());
                    tariff.setMax(node.findValue("price").findValue("max").toString());
                    tariff.setTotalSeats(node.findValue("numberOfSeats").findValue("totalSeats").toString());
                    listTariff.add(tariff);
                }
                ozonResponse.setTariffs(listTariff);
                ozonResponses.add(ozonResponse);

            }
            log.error(ozonResponses.get(0));
        } catch (JsonProcessingException e) {
            log.error("Error when parsing Ozon Travel response", e);
        }
        return ozonResponses;
    }
}
