
package com.xb.gw.overseas.model.admin_reject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "xmlns",
    "Fr",
    "To",
    "BizMsgIdr",
    "MsgDefIdr",
    "CreDt"
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppHdr {

    @JsonProperty("xmlns")
    private String xmlns;
    @JsonProperty("Fr")
    private Fr fr;
    @JsonProperty("To")
    private To to;
    @JsonProperty("BizMsgIdr")
    private String bizMsgIdr;
    @JsonProperty("MsgDefIdr")
    private String msgDefIdr;
    @JsonProperty("CreDt")
    private LocalDateTime creDt;

}
