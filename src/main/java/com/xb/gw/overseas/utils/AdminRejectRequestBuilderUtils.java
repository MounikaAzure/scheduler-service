package com.xb.gw.overseas.utils;

import com.xb.gw.overseas.model.admin_reject.*;

import java.time.LocalDateTime;

public class AdminRejectRequestBuilderUtils {

    public static final String CDATA_STARTING_TAG = "<![CDATA[";
    public static final String CDATA_ENDING_TAG = "]]>";

    public static AdminRejectMessage buildAdminRejectMessage(AdminRejectMessageDataHolder adminRejectDataHolder){
        return AdminRejectMessage.builder()
                .issuer(adminRejectDataHolder.getIssuer())
                .issueTime(adminRejectDataHolder.getIssueTime())
                .payload(Payload.builder()
                        .busMsg(BusMsg.builder()
                                .appHdr(AppHdr.builder()
                                        .xmlns(adminRejectDataHolder.getBizAppHeader())
                                        .fr(Fr.builder()
                                                .fIId(FIId.builder()
                                                        .finInstnId(FinInstnId.builder()
                                                                .bicfi(adminRejectDataHolder.getInstructingAgentBic())
                                                                .build())
                                                        .build())
                                                .build())
                                        .to(To.builder()
                                                .fIId(FIId.builder()
                                                        .finInstnId(FinInstnId.builder()
                                                                .bicfi(adminRejectDataHolder.getInstructedAgentBic())
                                                                .build())
                                                        .build())
                                                .build())
                                        .bizMsgIdr(adminRejectDataHolder.getBizMsgId())
                                        .msgDefIdr(adminRejectDataHolder.getIsoMsgType())
                                        .creDt(LocalDateTime.now())
                                        .build())
                                .document(Document.builder()
                                        .messageReject(MessageReject.builder()
                                                .rltdRef(RltdRef.builder()
                                                        .ref(adminRejectDataHolder.getUniqueMsgRefId())
                                                        .build())
                                                .rsn(Rsn.builder()
                                                        .rjctgPtyRsn(adminRejectDataHolder.getRejectRsnCode())
                                                        .rsnDesc(adminRejectDataHolder.getRejectRsnDescription())
                                                        .addtlData(encloseInCDATA(adminRejectDataHolder.getOriginalReqMessage()))
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();
    }
    private static String encloseInCDATA(String originalReqMessage){
        return CDATA_STARTING_TAG +originalReqMessage+ CDATA_ENDING_TAG;
    }
}
