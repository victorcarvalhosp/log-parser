package com.ef.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bloqued_ip")
public class BloquedIp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="search_log_id")
    private SearchLog searchLog;

    @Column(nullable=false)
    private String ip;

    @Column(nullable=false)
    private Long totalRequests;

    @Column(nullable=false)
    private String comments;

    public BloquedIp(String ip, Long totalRequests) {
        this.ip = ip;
        this.totalRequests = totalRequests;
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }

    public void setSearchLog(SearchLog searchLog) {
        this.searchLog = searchLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Long totalRequests) {
        this.totalRequests = totalRequests;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
