
package com.xb.gw.overseas.model.admin_reject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AppHdr",
    "Document"
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusMsg {

    @JsonProperty("AppHdr")
    private AppHdr appHdr;
    @JsonProperty("Document")
    private Document document;

}
