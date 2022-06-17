package com.xb.gw.overseas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOOKUP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, length = 45)
    private String id;

    @Column(name = "STATUS", length = 45)
    private String status;

    @Column(name = "LINKAGE", length = 45)
    private String linkage;

    @Column(name = "SINGAPORE_LOOKUP_ID", length = 45)
    private String singaporeLookupId;

    @Column(name = "OVERSEAS_LOOKUP_ID", length = 45)
    private String overseasLookupId;

    @Column(name = "SINGAPORE_LOOKUP_INSTRUCTION_ID", length = 45)
    private String singaporeLookupInstructionId;

    @Column(name = "OVERSEAS_LOOKUP_INSTRUCTION_ID", length = 45)
    private String overseasLookupInstructionId;

    @Column(name = "GW_REQUEST_RECEIVED_TIME", columnDefinition = "TIMESTAMP")
    private LocalDateTime gwRequestReceivedTime;

    @Column(name = "GW_REQUEST_GENERATED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime gwRequestGeneratedTime;

    @Column(name = "GW_RESPONSE_RECEIVED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime gwResponseReceivedTime;

    @Column(name = "GW_REQUEST_COMPLETED_TIME",columnDefinition = "TIMESTAMP")
    private LocalDateTime gwRequestCompletedTime;

    @Column(name = "CREATED_ON",columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;

    @Column(name = "LAST_UPDATED_ON",columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdatedOn;

}