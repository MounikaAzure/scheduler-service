package com.xb.gw.overseas.job.listener.processor;

import com.xb.gw.overseas.entity.Lookup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;

@Slf4j
public class OverseasLookupProcessListener implements ItemProcessListener<Lookup, Lookup> {

    @Override
    public void beforeProcess(Lookup lookup) {
        log.info("beforeProcess");
    }

    @Override
    public void afterProcess(Lookup lookup, Lookup updatedLookup) {
        log.info("afterProcess: {}   ---> {} ", lookup, updatedLookup);
    }

    @Override
    public void onProcessError(Lookup lookup, Exception e) {
        log.info("onProcessError {}",e);
    }
}
