package com.example.WoTrain.entity.POJOResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Trains"
})
@Data
public class RZDResponse implements Response {

    @JsonProperty("Trains")
    private List<TrainRZD> trains = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "MinPrice",
            "MaxPrice",
            "CarTypeName",
            "TotalPlaceQuantity"
    })
    @Data
    class CarGroup {

        @JsonProperty("MinPrice")
        private Double minPrice;
        @JsonProperty("MaxPrice")
        private Integer maxPrice;
        @JsonProperty("CarTypeName")
        private String carTypeName;
        @JsonProperty("TotalPlaceQuantity")
        private Integer totalPlaceQuantity;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "CarGroups",
            "DisplayTrainNumber",
            "DepartureDateTime",
            "ArrivalDateTime",
            "DestinationStationName",
            "OriginStationName"
    })
    @Data
    class TrainRZD {

        @JsonProperty("CarGroups")
        private List<CarGroup> carGroups = null;
        @JsonProperty("DisplayTrainNumber")
        private String displayTrainNumber;
        @JsonProperty("DepartureDateTime")
        private String departureDateTime;
        @JsonProperty("ArrivalDateTime")
        private String arrivalDateTime;
        @JsonProperty("DestinationStationName")
        private String destinationStationName;
        @JsonProperty("OriginStationName")
        private String originStationName;
    }
}
