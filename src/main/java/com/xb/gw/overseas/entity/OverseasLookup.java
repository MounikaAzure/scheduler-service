package com.xb.gw.overseas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "overseas_lookup")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OverseasLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length = 45)
    private String id;

    @Column(name = "REQ_BIZ_MESSAGE_ID", length = 45)
    private String reqBizMessageId;

    @Column(name = "REQ_MESSAGE_DEF_IDENTIFIER", length = 45)
    private String reqMessageDefIdentifier;

    @Column(name = "REQ_MESSAGE_ID", length = 45)
    private String reqMessageId;

    @Column(name = "REQ_CREATED_DATE_TIME", columnDefinition = "TIMESTAMP")
    private LocalDateTime reqCreatedDateTime;

    @Column(name = "REQ_SENDER_AGENT", length = 45)
    private String reqSenderAgent;

    @Column(name = "REQ_INSTRUCTION_ID", length = 45)
    private String reqInstructionId;

    @Column(name = "REQ_END_TO_END_ID", length = 45)
    private String reqEndToEndId;

    @Column(name = "REQ_INSTRUCTED_AMT", length = 45)
    private String reqInstructedAmt;

    @Column(name = "REQ_INSTRUCTED_AMT_CCY", length = 45)
    private String reqInstructedAmtCcy;

    @Column(name = "REQ_EXCHANGE_RATE", length = 45)
    private String reqExchangeRate;

    @Column(name = "REQ_DEBTOR_NAME", length = 45)
    private String reqDebtorName;

    @Column(name = "REQ_DEBTOR_ID", length = 45)
    private String reqDebtorId;

    @Column(name = "REQ_PROXY_ONLY_ID", length = 45)
    private String reqProxyOnlyId;

    @Column(name = "REQ_PROXY_RTRVL_TYPE", length = 45)
    private String reqProxyRtrvlType;

    @Column(name = "REQ_PROXY_RTRVL_VALUE", length = 45)
    private String reqProxyRtrvlValue;

    @Column(name = "REQ_ADDITIONAL_DATA", length = 45)
    private String reqAdditionalData;

    @Column(name = "RES_BIZ_MESSAGE_ID", length = 45)
    private String resBizMessageId;

    @Column(name = "RES_MESSAGE_DEF_IDENTIFIER", length = 45)
    private String resMessageDefIdentifier;

    @Column(name = "RES_MESSAGE_ID", length = 45)
    private String resMessageId;

    @Column(name = "RES_CREATED_DATE_TIME", columnDefinition = "TIMESTAMP")
    private LocalDateTime resCreatedDateTime;

    @Column(name = "RES_SENDER_AGENT", length = 45)
    private String resSenderAgent;

    @Column(name = "RES_ORIGINAL_MESSAGE_ID", length = 45)
    private String resOriginalMessageId;

    @Column(name = "RES_ORIGINAL_MESSAGE_DEF_IDENTIFIER", length = 45)
    private String resOriginalMessageDefIdentifier;

    @Column(name = "RES_ORIGINAL_CREATED_DATE_TIME", length = 45)
    private String resOriginalCreatedDateTime;

    @Column(name = "RES_ORIGINAL_TXN_AMT", length = 45)
    private String resOriginalTxnAmt;

    @Column(name = "RES_ORIGINAL_TXN_AMT_CCY", length = 45)
    private String resOriginalTxnAmtCcy;

    @Column(name = "RES_ORIGINAL_INSTRUCTION_ID", length = 45)
    private String resOriginalInstructionId;

    @Column(name = "RES_ORIGINAL_END_TO_END_ID", length = 45)
    private String resOriginalEndToEndId;

    @Column(name = "RES_ORIGINAL_LOOKUP_ORIGINAL_ID", length = 45)
    private String resOriginalLookupOriginalId;

    @Column(name = "RES_ORIGINAL_LOOKUP_RTVL_VALUE", length = 45)
    private String resOriginalLookupRtvlValue;

    @Column(name = "RES_ORIGINAL_LOOKUP_RTVL_TYPE", length = 45)
    private String resOriginalLookupRtvlType;

    @Column(name = "RES_STATUS", length = 45)
    private String resStatus;

    @Column(name = "RES_REASON_CODE", length = 45)
    private String resReasonCode;

    @Column(name = "RES_REASON_CODE_ADDITIONAL_INFO", length = 45)
    private String resReasonCodeAdditionalInfo;

    @Column(name = "RES_PRXY_TYPE", length = 45)
    private String resPrxyType;

    @Column(name = "RES_PRXY_VALUE", length = 45)
    private String resPrxyValue;

    @Column(name = "RES_REGN_ID", length = 45)
    private String resRegnId;

    @Column(name = "RES_REGN_DISPLAY_NAME", length = 45)
    private String resRegnDisplayName;

    @Column(name = "RES_REGN_AGENT", length = 45)
    private String resRegnAgent;

    @Column(name = "RES_REGN_ACCOUNT_ID", length = 45)
    private String resRegnAccountId;

    @Column(name = "RES_REGN_PRTRY", length = 45)
    private String resRegnPrtry;

    @Column(name = "RES_REGN_NAME", length = 45)
    private String resRegnName;

    @Column(name = "RES_ADDITIONAL_DATA", length = 45)
    private String resAdditionalData;

    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;

    @Column(name = "LAST_UPDATED_ON", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdatedOn;

}