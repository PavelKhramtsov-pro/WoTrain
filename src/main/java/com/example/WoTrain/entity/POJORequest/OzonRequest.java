package com.example.WoTrain.entity.POJORequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "routes",
        "adults",
        "children",
        "infants"
})
@Data
 class Input {

    @JsonProperty("routes")
    private List<Route> routes = new ArrayList<>();
    @JsonProperty("adults")
    private Integer adults = 1;
    @JsonProperty("children")
    private Integer children = 0;
    @JsonProperty("infants")
    private Integer infants = 0;
}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "from",
        "to"
})
@Data
 class Route {

    @JsonProperty("date")
    private String date;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operationName",
        "variables",
        "query"
})
@Data
public class OzonRequest implements Request{

    @JsonProperty(value = "operationName")
    private String operationName = "RailwaySearch";
    @JsonProperty("variables")
    private Variables variables = new Variables();
    @JsonProperty(value = "query")
    private String query = "query RailwaySearch($input: RailwaySearchInput!) {  railwaySearch(input: $input) {    searchId    expires    gds    newDate    trips {      id      segments {        arrivalStation {          code          name          providerName          __typename        }        arrivalTime        departureStation {          code          name          providerName          __typename        }        departureTime        duration        train {          arrivalStation {            code            name            providerName            city            __typename          }          brand          departureStation {            code            name            providerName            city            __typename          }          departureTime          isSuburbanTrain          numberOfLevels          name          number          displayNumber          category          remoteCheckIn          __typename        }        __typename      }      tariffs {        carrier        category        twoSeatsTicket        fourSeatsTicket        hasNonRefundableTariff        numberOfSeats {          totalSeats          sittingSeats          upperSeats          lowerSeats          sideUpperSeats          sideLowerSeats          maleSeats          femaleSeats          unknownGenderSeats          mixed          __typename        }        price {          max          min          __typename        }        __typename      }      __typename    }    __typename  }}";
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "input"
})
@Data
 class Variables {

    @JsonProperty("input")
    private Input input = new Input();

}