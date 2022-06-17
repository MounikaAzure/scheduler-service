package com.xb.gw.overseas.job.reader;

import com.xb.gw.overseas.entity.Lookup;
import com.xb.gw.overseas.repository.LookupRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

/**
 *
 * If status is “REQUEST_SENT_TO_PAYNOW”,
 * And GW_REQUEST_RECEIVED_TIME > 5 seconds or LAST_UPDATED_ON > 5 seconds
 *
 * SELECT * FROM LOOKUP where STATUS= ’REQUEST_SENT_TO_PAYNOW’ and GW_REQUEST_RECEIVED_TIME >
 */
@Component
@RequiredArgsConstructor
public class OverseasLookupReader implements ItemReader<Lookup> {

    private final LookupRepository lookupRepository;
    private Iterator<Lookup> lookupIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        lookupIterator = lookupRepository.findAll().iterator();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now "+now);
        LocalDateTime oldTimeStamp = now.minusSeconds(5);
        List<Lookup> request_sent_to_paynow = lookupRepository.findAllByStatusAndLastGwRequestReceivedTime("REQUEST_SENT_TO_PAYNOW", oldTimeStamp);
        System.out.println("request_sent_to_paynow "+request_sent_to_paynow);
    }

    @Override
    public Lookup read() {
        if (lookupIterator != null && lookupIterator.hasNext()) {
            return lookupIterator.next();
        } else {
            return null;
        }
    }
}
