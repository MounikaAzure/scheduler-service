
package com.xb.gw.overseas.model.admin_reject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RjctgPtyRsn",
    "RsnDesc",
    "AddtlData"
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rsn {

    @JsonProperty("RjctgPtyRsn")
    private String rjctgPtyRsn;
    @JsonProperty("RsnDesc")
    private String rsnDesc;
    @JsonProperty("AddtlData")
    private String addtlData;

}
