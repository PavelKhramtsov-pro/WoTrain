package com.example.WoTrain.entity.POJORequest;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Origin",
        "Destination",
        "DepartureDate",
        "CarGrouping",
        "GetByLocalTime",
        "SpecialPlacesDemand"
})
@Data
public class RZDRequest implements Request{

    @JsonProperty("Origin")
    private String origin;
    @JsonProperty("Destination")
    private String destination;
    @JsonProperty("DepartureDate")
    private String departureDate;
    @JsonProperty("CarGrouping")
    private String carGrouping;
    @JsonProperty("GetByLocalTime")
    private Boolean getByLocalTime;
    @JsonProperty("SpecialPlacesDemand")
    private String specialPlacesDemand;

}