package com.xb.gw.overseas.repository;

import com.xb.gw.overseas.entity.OverseasLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverseasLookupRepository extends JpaRepository<OverseasLookup,String> {
}
