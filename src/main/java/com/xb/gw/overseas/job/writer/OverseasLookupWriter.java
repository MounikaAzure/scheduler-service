package com.xb.gw.overseas.job.writer;

import com.xb.gw.overseas.entity.Lookup;
import com.xb.gw.overseas.repository.LookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OverseasLookupWriter implements ItemWriter<Lookup> {

    private LookupRepository lookupRepository;

    @Override
    public void write(List<? extends Lookup> list) throws Exception {
        lookupRepository.saveAll(list);
    }
}
