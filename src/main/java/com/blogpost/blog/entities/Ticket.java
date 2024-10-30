package com.blogpost.blog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable{

    
	private static final long serialVersionUID = 1L;


	@Id
    @Column(name = "SrNo")
    private int SrNo;

    @JsonProperty("TicketID")
    @Column(name = "TicketID")
    private String TicketID;
  
    @JsonProperty("Status")
    @Column(name = "Status")
    private String Status;
 
    @JsonProperty("Description")
    @Column(name = "Description")
    private String Description;

    @JsonProperty("Enggmail")
    @Column(name = "Enggmail")
    private String Enggmail;
    
    public String getEnggmail() {
		return Enggmail;
	}

	public void setEnggmail(String enggmail) {
		Enggmail = enggmail;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	@JsonProperty("Username")
    @Column(name = "Username")
    private String Username;

    @JsonProperty("FullName")
    @Column(name = "FullName")
    private String FullName;

    @JsonProperty("Company")
    @Column(name = "Company")
    private String Company;

    @JsonProperty("EnggCompany")
    @Column(name = "EnggCompany")
    private String EnggCompany;
    
    
    public String getEnggCompany() {
		return EnggCompany;
	}

	public void setEnggCompany(String enggCompany) {
		EnggCompany = enggCompany;
	}

	@JsonProperty("Branch")
    @Column(name = "Branch")
    private String Branch;

    @JsonProperty("Department")
    @Column(name = "Department")
    private String Department;

    @JsonProperty("Location")
    @Column(name = "Location")
    private String Location;

    @JsonProperty("RequestType")
    @Column(name = "RequestType")
    private String RequestType;

    // Subject and Categories
    @JsonProperty("Subject")
    @Column(name = "Subject")
    private String Subject;

    @JsonProperty("Category")
    @Column(name = "Category")
    private String Category;

    @JsonProperty("SubCategory1")
    @Column(name = "SubCategory1")
    private String SubCategory1;

    @JsonProperty("SubCategory2")
    @Column(name = "SubCategory2")
    private String SubCategory2;

    @JsonProperty("Priority")
    @Column(name = "Priority")
    private String Priority;

    @JsonProperty("Severity")
    @Column(name = "Severity")
    private String Severity;

    // Attachment
    @JsonProperty("Attachment")
    @Column(name = "Attachment")
    private String Attachment;

    // Status and Dates Info
    @JsonProperty("currentDateTime")
    @Column(name = "currentDateTime")
    private String CurrentDateTime;

    @JsonProperty("RaisedBy")
    @Column(name = "RaisedBy")
    private String RaisedBy;
    
    @JsonProperty("RaisedByFullName")
    @Column(name = "RaisedByFullName")
    private String RaisedByFullName;

    @JsonProperty("RaiseDate")
    @Column(name = "RaiseDate")
    private String RaiseDate;

    @JsonProperty("AssignDate")
    @Column(name = "AssignDate")
    private String AssignDate;

    // Assignment Details
    @JsonProperty("AssignBy")
    @Column(name = "AssignBy")
    private String AssignBy;

    @JsonProperty("GroupName")
    @Column(name = "GroupName")
    private String GroupName;
    
    @JsonProperty("EngineerName")
    @Column(name = "EngineerName")
    private String EngineerName;
    
    public String getEngineerName() {
		return EngineerName;
	}

	public void setEngineerName(String engineerName) {
		EngineerName = engineerName;
	}

	public String getEngineerFullName() {
		return EngineerFullName;
	}

	public void setEngineerFullName(String engineerFullName) {
		EngineerFullName = engineerFullName;
	}

	@JsonProperty("EngineerFullName")
    @Column(name = "EngineerFullName")
    private String EngineerFullName;

    @JsonProperty("AssignByFullName")
    @Column(name = "AssignByFullName")
    private String AssignByFullName;

    @JsonProperty("ResolvedBy")
    @Column(name = "ResolvedBy")
    private String ResolvedBy;

    @JsonProperty("ResolvedByFullName")
    @Column(name = "ResolvedByFullName")
    private String ResolvedByFullName;

    @JsonProperty("ClosedByUsername")
    @Column(name = "ClosedByUsername")
    private String ClosedByUsername;

    @JsonProperty("ClosedByFullName")
    @Column(name = "ClosedByFullName")
    private String ClosedByFullName;

    @JsonProperty("ClosedByDate")
    @Column(name = "ClosedByDate")
    private String ClosedByDate;

	public int getSrNo() {
		return SrNo;
	}

	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	public String getTicketID() {
		return TicketID;
	}

	public void setTicketID(String ticketID) {
		TicketID = ticketID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		RequestType = requestType;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getSubCategory1() {
		return SubCategory1;
	}

	public void setSubCategory1(String subCategory1) {
		SubCategory1 = subCategory1;
	}

	public String getSubCategory2() {
		return SubCategory2;
	}

	public void setSubCategory2(String subCategory2) {
		SubCategory2 = subCategory2;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public String getAttachment() {
		return Attachment;
	}

	public void setAttachment(String attachment) {
		Attachment = attachment;
	}



	public String getRaisedBy() {
		return RaisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		RaisedBy = raisedBy;
	}

	

	public String getCurrentDateTime() {
		return CurrentDateTime;
	}

	public void setCurrentDateTime(String currentDateTime) {
		CurrentDateTime = currentDateTime;
	}

	public String getRaisedByFullName() {
		return RaisedByFullName;
	}

	public void setRaisedByFullName(String raisedByFullName) {
		RaisedByFullName = raisedByFullName;
	}

	public String getRaiseDate() {
		return RaiseDate;
	}

	public void setRaiseDate(String raiseDate) {
		RaiseDate = raiseDate;
	}

	public String getAssignDate() {
		return AssignDate;
	}

	public void setAssignDate(String assignDate) {
		AssignDate = assignDate;
	}

	public String getAssignBy() {
		return AssignBy;
	}

	public void setAssignBy(String assignBy) {
		AssignBy = assignBy;
	}

	public String getGroupName() {
		return GroupName;
	}

	public void setGroupName(String groupName) {
		GroupName = groupName;
	}

	public String getAssignByFullName() {
		return AssignByFullName;
	}

	public void setAssignByFullName(String assignByFullName) {
		AssignByFullName = assignByFullName;
	}

	public String getResolvedBy() {
		return ResolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		ResolvedBy = resolvedBy;
	}

	public String getResolvedByFullName() {
		return ResolvedByFullName;
	}

	public void setResolvedByFullName(String resolvedByFullName) {
		ResolvedByFullName = resolvedByFullName;
	}

	public String getClosedByUsername() {
		return ClosedByUsername;
	}

	public void setClosedByUsername(String closedByUsername) {
		ClosedByUsername = closedByUsername;
	}

	public String getClosedByFullName() {
		return ClosedByFullName;
	}

	public void setClosedByFullName(String closedByFullName) {
		ClosedByFullName = closedByFullName;
	}

	public String getClosedByDate() {
		return ClosedByDate;
	}

	public void setClosedByDate(String closedByDate) {
		ClosedByDate = closedByDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ticket [SrNo=" + SrNo + ", TicketID=" + TicketID + ", Status=" + Status + ", Description=" + Description
				+ ", Enggmail=" + Enggmail + ", Username=" + Username + ", FullName=" + FullName + ", Company="
				+ Company + ", EnggCompany=" + EnggCompany + ", Branch=" + Branch + ", Department=" + Department
				+ ", Location=" + Location + ", RequestType=" + RequestType + ", Subject=" + Subject + ", Category="
				+ Category + ", SubCategory1=" + SubCategory1 + ", SubCategory2=" + SubCategory2 + ", Priority="
				+ Priority + ", Severity=" + Severity + ", Attachment=" + Attachment + ", CurrentDateTime="
				+ CurrentDateTime + ", RaisedBy=" + RaisedBy + ", RaisedByFullName=" + RaisedByFullName + ", RaiseDate="
				+ RaiseDate + ", AssignDate=" + AssignDate + ", AssignBy=" + AssignBy + ", GroupName=" + GroupName
				+ ", EngineerName=" + EngineerName + ", EngineerFullName=" + EngineerFullName + ", AssignByFullName="
				+ AssignByFullName + ", ResolvedBy=" + ResolvedBy + ", ResolvedByFullName=" + ResolvedByFullName
				+ ", ClosedByUsername=" + ClosedByUsername + ", ClosedByFullName=" + ClosedByFullName
				+ ", ClosedByDate=" + ClosedByDate + "]";
	}

	

}
