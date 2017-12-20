package com.ef.entities;

import com.ef.enums.DurationEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="search_log")
public class SearchLog {

    @Id
    private Long id;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column
    @Enumerated(EnumType.STRING)
    private DurationEnum duration;

    @Column
    private Integer threshold;

    @ManyToMany
    @JoinTable(name = "bloqued_ips", joinColumns = { @JoinColumn(name = "search_log_id") }, inverseJoinColumns = { @JoinColumn(name = "bloqued_ip_id") })
    private List<BloquedIp> bloquedIps;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public DurationEnum getDuration() {
        return duration;
    }

    public void setDuration(DurationEnum duration) {
        this.duration = duration;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public List<BloquedIp> getBloquedIps() {
        return bloquedIps;
    }

    public void setBloquedIps(List<BloquedIp> bloquedIps) {
        this.bloquedIps = bloquedIps;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
}
