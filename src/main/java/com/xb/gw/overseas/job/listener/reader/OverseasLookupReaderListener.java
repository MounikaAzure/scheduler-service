package com.xb.gw.overseas.job.listener.reader;

import com.xb.gw.overseas.entity.Lookup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;

@Slf4j
public class OverseasLookupReaderListener implements ItemReadListener<Lookup> {

    @Override
    public void beforeRead() {
        log.info("beforeRead");
    }

    @Override
    public void afterRead(Lookup lookup) {
        log.info("afterRead: {} ",lookup.toString());
    }

    @Override
    public void onReadError(Exception e) {
        log.info("onReadError {} ",e);
    }
}
