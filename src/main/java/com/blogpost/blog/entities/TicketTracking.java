package com.blogpost.blog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TicketTracking")
public class TicketTracking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int srNo;
    
    
    @JsonProperty("Ticket_ID")
    @Column(name = "Ticket_ID")
    private String ticketID;

    public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	@JsonProperty("Message")
    @Column(name = "Message")
    private String message;

    @JsonProperty("Description")
    @Column(name = "Description")
    private String description;

    @JsonProperty("Priority")
    @Column(name = "Priority")
    private String priority;

    @JsonProperty("Severity")
    @Column(name = "Severity")
    private String severity;

//    @Enumerated(EnumType.STRING)
    @JsonProperty("Status")
    @Column(name = "Status")
    private String status;

    @JsonProperty("ActivityDateTime")
    @Column(name = "ActivityDateTime")
    private String activityDateTime;

    @JsonProperty("ActivityName")
    @Column(name = "ActivityName")
    private String activityName;

    @JsonProperty("ActivityCompany")
    @Column(name = "ActivityCompany")
    private String activityCompany;

    @JsonProperty("Category")
    @Column(name = "Category")
    private String category;

    @JsonProperty("SubCategory1")
    @Column(name = "SubCategory1")
    private String subCategory1;

    @JsonProperty("SubCategory2")
    @Column(name = "SubCategory2")
    private String subCategory2;

    @JsonProperty("Subject")
    @Column(name = "Subject")
    private String subject;

    @JsonProperty("TicketRaisedByName")
    @Column(name = "TicketRaisedByName")
    private String ticketRaisedByName;

    @JsonProperty("TicketRaisedByCompany")
    @Column(name = "TicketRaisedByCompany")
    private String ticketRaisedByCompany;

    
    
    // Getters and Setters for each field
    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityDateTime() {
        return activityDateTime;
    }

    public void setActivityDateTime(String activityDateTime) {
        this.activityDateTime = activityDateTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityCompany() {
        return activityCompany;
    }

    public void setActivityCompany(String activityCompany) {
        this.activityCompany = activityCompany;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory1() {
        return subCategory1;
    }

    public void setSubCategory1(String subCategory1) {
        this.subCategory1 = subCategory1;
    }

    public String getSubCategory2() {
        return subCategory2;
    }

    public void setSubCategory2(String subCategory2) {
        this.subCategory2 = subCategory2;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTicketRaisedByName() {
        return ticketRaisedByName;
    }

    public void setTicketRaisedByName(String ticketRaisedByName) {
        this.ticketRaisedByName = ticketRaisedByName;
    }

    public String getTicketRaisedByCompany() {
        return ticketRaisedByCompany;
    }

    public void setTicketRaisedByCompany(String ticketRaisedByCompany) {
        this.ticketRaisedByCompany = ticketRaisedByCompany;
    }

	@Override
	public String toString() {
		return "TicketTracking [srNo=" + srNo + ", ticketID=" + ticketID + ", message=" + message + ", description="
				+ description + ", priority=" + priority + ", severity=" + severity + ", status=" + status
				+ ", activityDateTime=" + activityDateTime + ", activityName=" + activityName + ", activityCompany="
				+ activityCompany + ", category=" + category + ", subCategory1=" + subCategory1 + ", subCategory2="
				+ subCategory2 + ", subject=" + subject + ", ticketRaisedByName=" + ticketRaisedByName
				+ ", ticketRaisedByCompany=" + ticketRaisedByCompany + "]";
	}

	
    
}
