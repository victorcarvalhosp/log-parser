package com.ef.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="log")
public class Log {

    @Id
    private Long id;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable=false)
    private String ip;

    @Column(nullable=false)
    private String request;

    @Column(nullable=false)
    private Integer status;

    @Column(nullable=false)
    private String userAgent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
