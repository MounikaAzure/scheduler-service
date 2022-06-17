package com.xb.gw.overseas.job.processor;

import com.xb.gw.overseas.api.client.GenericRestClient;
import com.xb.gw.overseas.api.client.GenericWebClient;
import com.xb.gw.overseas.config.JobSchedulerConfigProperties;
import com.xb.gw.overseas.entity.Lookup;
import com.xb.gw.overseas.entity.OverseasLookup;
import com.xb.gw.overseas.model.admin_reject.AdminRejectMessage;
import com.xb.gw.overseas.repository.OverseasLookupRepository;
import com.xb.gw.overseas.utils.AdminRejectMessageDataHolder;
import com.xb.gw.overseas.utils.AdminRejectRequestBuilderUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

/**
 * For each LOOKUP object get overseas lookup object and prepare the Admin API request and send it to Overseas with message prxy.004.001.02
 * OVERSEAS_LOOKUP_REQUEST objects
 * 	Modify the status to TIMEDOUT_BY_PAYNOW
 * 	Update the GW_REQUEST_COMPLETED_TIME as current time.
 */


@Component
@Slf4j
@AllArgsConstructor
public class OverseasLookupProcessor implements ItemProcessor<Lookup, Lookup> {

    public static final String TIMEDOUT_BY_PAYNOW = "TIMEDOUT_BY_PAYNOW";
    private OverseasLookupRepository overseasLookupRepository;

    private GenericRestClient genericRestClient;

    private JobSchedulerConfigProperties jobSchedulerConfigProperties;

    @Override
    public Lookup process(Lookup lookupItem) {
        Optional<OverseasLookup> optionalOverseasLookup = overseasLookupRepository.findById(lookupItem.getOverseasLookupId());
        AdminRejectMessageDataHolder adminRejectMessageDataHolder = optionalOverseasLookup.map(e -> AdminRejectMessageDataHolder.builder()
                .issuer(e.getReqSenderAgent())
                .instructedAgentBic("DBSIBXXXX")
                .instructingAgentBic("SBIN34XXX")
                .issueTime(LocalDateTime.now())
                .bizAppHeader(e.getReqMessageId())
                .bizMsgId(e.getReqBizMessageId())
                .originalReqMessage("req message")
                .rejectRsnCode("6XX") // need to know timeout error code
                .rejectRsnCode("Timeout error, requeest not initated from Paynow")
                .build()).orElse(null);
        AdminRejectMessage adminRejectMessage = AdminRejectRequestBuilderUtils.buildAdminRejectMessage(adminRejectMessageDataHolder);
        ResponseEntity<String> responseEntity = genericRestClient.execute(jobSchedulerConfigProperties.getOverseasEndpointUrl(), HttpMethod.POST, adminRejectMessage,
                String.class, HttpHeaders.EMPTY);
        log.debug("invoked overseas endpoint with admin reject message, response body is {} , response status code  "+responseEntity.getBody(),responseEntity.getStatusCode());
       // Modify the status to TIMEDOUT_BY_PAYNOW
       // Update the GW_REQUEST_COMPLETED_TIME as current time.
        lookupItem.setStatus(TIMEDOUT_BY_PAYNOW);
        lookupItem.setLastUpdatedOn(LocalDateTime.now());
        // do we need to update OVERSEAS_LOOKUP table as well with response fields. If needed update here it self
        return lookupItem;
    }
}
