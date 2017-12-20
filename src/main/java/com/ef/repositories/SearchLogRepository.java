package com.ef.repositories;

import com.ef.entities.BloquedIp;
import com.ef.entities.SearchLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SearchLogRepository extends CrudRepository<SearchLog, Long> {
}
