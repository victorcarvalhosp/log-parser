package com.ef.repositories;

import com.ef.entities.BloquedIp;
import com.ef.entities.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {
    @Query("SELECT new com.ef.entities.BloquedIp(l.ip, COUNT(l.ip)) FROM Log l WHERE l.date between :startDate and :finalDate GROUP BY l.ip HAVING COUNT (l.ip) >= :threshold")
    List<BloquedIp> findBloquedIpsByDateAndThreshold(@Param("startDate") Date startDate, @Param("finalDate") Date finalDate, @Param("threshold")Long threshold);
}
