package com.example.WoTrain.entity.POJOResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codeArrivalStation",
        "arrivalTime",
        "codedepartureStation",
        "departureTime",
        "displayNumber",
        "tariffs"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OzonResponse {

    @JsonProperty("arrivalStation.code")
    private String codeArrivalStation;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
    @JsonProperty("departureStation.code")
    private String codedepartureStation;
    @JsonProperty("departureTime")
    private String departureTime;
    @JsonProperty("displayNumber")
    private String displayNumber;
    @JsonProperty("tariffs")
    private List<Tariff> tariffs = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "category",
            "totalSeats",
            "max",
            "min"
    })
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
     public class Tariff {
        @JsonProperty("category")
        private String category;
        @JsonProperty("totalSeats")
        private String totalSeats;
        @JsonProperty("max")
        private String max;
        @JsonProperty("min")
        private String min;
    }
}
