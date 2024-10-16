package com.blogpost.blog.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PortalMaster implements Serializable
{

	
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate srNo
    private Long srNo; // Primary key

    private String company;
    private String requestType;

    // Getters and Setters
    public Long getSrNo() {
        return srNo;
    }

    public void setSrNo(Long srNo) {
        this.srNo = srNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
