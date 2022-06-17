
package com.xb.gw.overseas.model.admin_reject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "issuer",
    "issueTime",
    "payload"
})
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminRejectMessage {

    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("issueTime")
    private LocalDateTime issueTime;
    @JsonProperty("payload")
    private Payload payload;
}
