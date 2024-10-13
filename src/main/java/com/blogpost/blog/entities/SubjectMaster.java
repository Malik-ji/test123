package com.blogpost.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubjectMaster {
    
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Primary key

	    private String company; // Company name
	  
	   
	    private String category; // Category
	    private String subCategory1; // Sub-category 1
	    private String subCategory2; // Sub-category 2
	    private String priority; // Priority
	    private String severity; // Severity

	    // Default constructor
	    public SubjectMaster() {
	    }

	    // Parameterized constructor
	    public SubjectMaster(String company, String category, String subCategory1, String subCategory2, String priority, String severity) {
	        this.company = company;
	     
	        this.category = category;
	        this.subCategory1 = subCategory1;
	        this.subCategory2 = subCategory2;
	        this.priority = priority;
	        this.severity = severity;
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
}
