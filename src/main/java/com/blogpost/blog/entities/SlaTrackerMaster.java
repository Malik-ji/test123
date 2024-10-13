package com.blogpost.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sla_tracker_master")
public class SlaTrackerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String priority;
    private String severity;
    private Integer slaDuration; // SLA duration in hours or days

    // Constructors
    public SlaTrackerMaster() {
    }

    public SlaTrackerMaster(String company, String priority, String severity, Integer slaDuration) {
        this.company = company;
        this.priority = priority;
        this.severity = severity;
        this.slaDuration = slaDuration;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getSlaDuration() {
        return slaDuration;
    }

    public void setSlaDuration(Integer slaDuration) {
        this.slaDuration = slaDuration;
    }
}
