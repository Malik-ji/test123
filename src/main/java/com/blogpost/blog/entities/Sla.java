package com.blogpost.blog.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sla")
public class Sla implements Serializable{

	
	private static final long serialVersionUID = 6732747865098884568L;

	@Id
    private int  srNo;
    
    public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	@Column(name = "TICKETID", nullable = false, length = 500)
    private String ticketId;

    @Column(name = "TICKETSTATUS", length = 500)
    private String ticketStatus;

    @Column(name = "PRIORITY", length = 500)
    private String priority;

    @Column(name = "SEVERITY", length = 500)
    private String severity;

    @Column(name = "STARTDATE", length = 500)
    private String startDate;

    @Column(name = "STOPDATE", length = 500)
    private String stopDate;

    @Column(name = "STARTENDTIME", length = 500)
    private String startEndTime;

    @Column(name = "ELAPSEDTIME", length = 500)
    private String elapsedTime;

    @Column(name = "HOLDSTARTDATE", length = 500)
    private String holdStartDate;

    @Column(name = "HOLDENDDATE", length = 500)
    private String holdEndDate;

    @Column(name = "HOLDDURATION", length = 500)
    private String holdDuration;

    @Column(name = "HOLDELAPSEDTIME", length = 500)
    private String holdElapsedTime;

    @Column(name = "SLATARGET", length = 500)
    private String slaTarget;

    @Column(name = "SLATIME", length = 500)
    private String slaTime;

    @Column(name = "SLASTATUS", length = 500)
    private String slaStatus;

    @Column(name = "ActualWorkingTime", length = 500)
    private String actualWorkingTime;

    @Column(name = "HOLDTIMECALCULATION", length = 255)
    private String holdTimeCalculation;

    @Column(name = 
    		"CALENDERCALACULATION", length = 255)
    private String calenderCalculation;

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

	@Override
	public String toString() {
		return "Sla [ticketId=" + ticketId + ", ticketStatus=" + ticketStatus + ", priority=" + priority + ", severity="
				+ severity + ", startDate=" + startDate + ", stopDate=" + stopDate + ", startEndTime=" + startEndTime
				+ ", elapsedTime=" + elapsedTime + ", holdStartDate=" + holdStartDate + ", holdEndDate=" + holdEndDate
				+ ", holdDuration=" + holdDuration + ", holdElapsedTime=" + holdElapsedTime + ", slaTarget=" + slaTarget
				+ ", slaTime=" + slaTime + ", slaStatus=" + slaStatus + ", actualWorkingTime=" + actualWorkingTime
				+ ", holdTimeCalculation=" + holdTimeCalculation + ", calenderCalculation=" + calenderCalculation + "]";
	}

  
}
