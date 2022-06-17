
package com.xb.gw.overseas.model.admin_reject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BusMsg"
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

    @JsonProperty("BusMsg")
    private BusMsg busMsg;
}
