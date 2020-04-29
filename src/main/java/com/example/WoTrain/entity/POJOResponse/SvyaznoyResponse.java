package com.example.WoTrain.entity.POJOResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coupes",
        "trainNum",
        "dateFrom",
        "timeFrom",
        "dateTo",
        "timeTo",
        "codeDepart",
        "codeArrival"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SvyaznoyResponse implements Response{
   @JsonProperty("coupes")
   private List<Coupe> coupes = null;
   @JsonProperty("trainNum")
   private String trainNum;
   @JsonProperty("dateFrom")
   private String dateFrom;
   @JsonProperty("timeFrom")
   private String timeFrom;
   @JsonProperty("dateTo")
   private String dateTo;
   @JsonProperty("timeTo")
   private String timeTo;
   @JsonProperty("codeDepart")
   private String codeDepart;
   @JsonProperty("codeArrival")
   private String codeArrival;
   @JsonInclude(JsonInclude.Include.NON_NULL)
   @JsonPropertyOrder({
           "places",
           "type",
           "price",
           "maxPrice"
   })
   @Data
   @JsonIgnoreProperties(ignoreUnknown = true)
   public class Coupe {

      @JsonProperty("places")
      private String places;
      @JsonProperty("type")
      private String type;
      @JsonProperty("price")
      private String price;
      @JsonProperty("maxPrice")
      private String maxPrice;

   }
}