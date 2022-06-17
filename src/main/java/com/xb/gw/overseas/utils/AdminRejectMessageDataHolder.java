package com.xb.gw.overseas.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AdminRejectMessageDataHolder {
    private  String issuer;
    private  LocalDateTime issueTime;
    private  String bizAppHeader;
    private  String instructingAgentBic;
    private  String instructedAgentBic;
    private  String bizMsgId;
    private  String isoMsgType;
    private  String uniqueMsgRefId;
    private  String rejectRsnCode;
    private  String rejectRsnDescription;
    private  String originalReqMessage;
}
