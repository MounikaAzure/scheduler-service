package com.xb.gw.overseas.job.listener.writer;

import com.xb.gw.overseas.entity.Lookup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

@Slf4j
public class OverseasLookupWriterListener implements ItemWriteListener<Lookup> {


    @Override
    public void beforeWrite(List<? extends Lookup> list) {
        log.debug("beforeWrite");
    }


    @Override
    public void afterWrite(List<? extends Lookup> list) {
        log.debug("after Job execution updated lookup list size {} ",list.size());
    }

    @Override
    public void onWriteError(Exception e, List<? extends Lookup> list) {
        log.debug("onWriteError");
    }
}
