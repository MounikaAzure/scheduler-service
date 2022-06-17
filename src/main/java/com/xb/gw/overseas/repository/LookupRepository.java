package com.xb.gw.overseas.repository;

import com.xb.gw.overseas.entity.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<Lookup,String> {
    // SELECT l FROM LOOKUP l where l.status= ’REQUEST_SENT_TO_PAYNOW’ and GW_REQUEST_RECEIVED_TIME > CURRENT_TIMESTAMP -3
    @Query("SELECT l FROM Lookup l  where l.status=:status and l.gwRequestReceivedTime >:agoLocalDateTime")
    List<Lookup> findAllByStatusAndLastGwRequestReceivedTime(@Param("status") String status, @Param("agoLocalDateTime")LocalDateTime agoLocalDateTime);
}
