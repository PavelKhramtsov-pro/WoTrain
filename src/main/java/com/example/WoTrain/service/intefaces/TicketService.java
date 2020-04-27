package com.example.WoTrain.service.intefaces;




import com.example.WoTrain.entity.POJORequest.OzonRequest;
import com.example.WoTrain.entity.POJORequest.RZDRequest;
import com.example.WoTrain.entity.POJORequest.Request;
import com.example.WoTrain.entity.POJOResponse.OzonResponse;
import com.example.WoTrain.entity.POJOResponse.RZDResponse;
import com.example.WoTrain.entity.POJOResponse.Response;

import java.util.List;

public interface TicketService<T,V> {
    List<T> getResponse(V request);
}
