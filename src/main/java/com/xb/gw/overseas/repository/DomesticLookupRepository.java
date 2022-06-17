package com.xb.gw.overseas.repository;

import com.xb.gw.overseas.entity.DomesticLookup;
import com.xb.gw.overseas.entity.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomesticLookupRepository extends JpaRepository<DomesticLookup,String> {
}
