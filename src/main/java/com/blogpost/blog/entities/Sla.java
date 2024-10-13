package com.blogpost.blog.entities;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sla")
public class Sla implements Serializable{

    @Id
    @Column(name = "TICKET_ID", nullable = false, length = 500)
    private String ticketId;

    @Column(name = "TICKET_STATUS", length = 500)
    private String ticketStatus;

    @Column(name = "PRIORITY", length = 500)
    private String priority;

    @Column(name = "SEVERITY", length = 500)
    private String severity;

    @Column(name = "START_DATE", length = 500)
    private String startDate;

    @Column(name = "STOP_DATE", length = 500)
    private String stopDate;

    @Column(name = "START_END_TIME", length = 500)
    private String startEndTime;

    @Column(name = "ELAPSED_TIME", length = 500)
    private String elapsedTime;

    @Column(name = "HOLD_START_DATE", length = 500)
    private String holdStartDate;

    @Column(name = "HOLD_END_DATE", length = 500)
    private String holdEndDate;

    @Column(name = "HOLD_DURATION", length = 500)
    private String holdDuration;

    @Column(name = "HOLD_ELAPSED_TIME", length = 500)
    private String holdElapsedTime;

    @Column(name = "SLA_TARGET", length = 500)
    private String slaTarget;

    @Column(name = "SLA_TIME", length = 500)
    private String slaTime;

    @Column(name = "SLA_STATUS", length = 500)
    private String slaStatus;

    @Column(name = "Actual_Working_Time", length = 500)
    private String actualWorkingTime;

    @Column(name = "HOLD_TIME_CALCULATION", length = 255, columnDefinition = "varchar(255) collate utf8_bin")
    private String holdTimeCalculation;

    @Column(name = "CALENDER_CALACULATION", length = 255, columnDefinition = "varchar(255) collate utf8_bin")
    private String calenderCalculation;

    // Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(String startEndTime) {
        this.startEndTime = startEndTime;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getHoldStartDate() {
        return holdStartDate;
    }

    public void setHoldStartDate(String holdStartDate) {
        this.holdStartDate = holdStartDate;
    }

    public String getHoldEndDate() {
        return holdEndDate;
    }

    public void setHoldEndDate(String holdEndDate) {
        this.holdEndDate = holdEndDate;
    }

    public String getHoldDuration() {
        return holdDuration;
    }

    public void setHoldDuration(String holdDuration) {
        this.holdDuration = holdDuration;
    }

    public String getHoldElapsedTime() {
        return holdElapsedTime;
    }

    public void setHoldElapsedTime(String holdElapsedTime) {
        this.holdElapsedTime = holdElapsedTime;
    }

    public String getSlaTarget() {
        return slaTarget;
    }

    public void setSlaTarget(String slaTarget) {
        this.slaTarget = slaTarget;
    }

    public String getSlaTime() {
        return slaTime;
    }

    public void setSlaTime(String slaTime) {
        this.slaTime = slaTime;
    }

    public String getSlaStatus() {
        return slaStatus;
    }

    public void setSlaStatus(String slaStatus) {
        this.slaStatus = slaStatus;
    }

    public String getActualWorkingTime() {
        return actualWorkingTime;
    }

    public void setActualWorkingTime(String actualWorkingTime) {
        this.actualWorkingTime = actualWorkingTime;
    }

    public String getHoldTimeCalculation() {
        return holdTimeCalculation;
    }

    public void setHoldTimeCalculation(String holdTimeCalculation) {
        this.holdTimeCalculation = holdTimeCalculation;
    }

    public String getCalenderCalculation() {
        return calenderCalculation;
    }

    public void setCalenderCalculation(String calenderCalculation) {
        this.calenderCalculation = calenderCalculation;
    }
}
