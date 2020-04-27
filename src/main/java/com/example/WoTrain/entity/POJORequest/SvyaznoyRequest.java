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
        "date",
        "from",
        "to"
})
@Data
public class SvyaznoyRequest implements Request{
    @JsonProperty("date")
    private String date;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;

}
