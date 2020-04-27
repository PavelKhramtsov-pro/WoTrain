package com.example.WoTrain.service.classInplement;

import com.example.WoTrain.entity.POJORequest.RZDRequest;
import com.example.WoTrain.entity.POJORequest.Request;
import com.example.WoTrain.entity.POJOResponse.RZDResponse;
import com.example.WoTrain.service.intefaces.TicketService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
@Log4j2
public class RZDService implements TicketService<RZDResponse,RZDRequest> {
    private final RestTemplate restTemplate = new RestTemplate();
    String URLOzon = "https://ticket.rzd.ru/apib2b/p/Railway/V1/Search/TrainPricing?service_provider=B2B_RZD";

    @Override
    public List<RZDResponse> getResponse(RZDRequest request) {
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        String response = restTemplate.exchange(URLOzon, HttpMethod.POST,httpEntity,String.class).getBody();
        log.error(response);
        return null;
    }
}