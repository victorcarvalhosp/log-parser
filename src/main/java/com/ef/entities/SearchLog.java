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
    @JoinTable(name = "search_logs", joinColumns = { @JoinColumn(name = "search_log_id") }, inverseJoinColumns = { @JoinColumn(name = "log_id") })
    private List<Log> logs;

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

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
