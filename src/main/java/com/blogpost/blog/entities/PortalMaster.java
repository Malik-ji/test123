package com.blogpost.blog.entities;

import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
public class PortalMaster {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate srNo
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
