package com.blogpost.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long srNo; // Auto-incremented

    private String company;
    private String category;
    private String subCategory1;
    private String subCategory2;

    // Constructors, Getters, and Setters
    public CategoryMaster() {
    }

    public CategoryMaster(String company, String category, String subCategory1, String subCategory2) {
        this.company = company;
        this.category = category;
        this.subCategory1 = subCategory1;
        this.subCategory2 = subCategory2;
    }

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
}
