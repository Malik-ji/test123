package com.blogpost.blog.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AutoAssignConfig")
public class AutoAssignConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "CATEGORY", length = 100)
    private String category;

    @Column(name = "PRIORITY", length = 50)
    private String priority;

    @Column(name = "ASSIGN_TIME")
    private String assignTime;

    @Column(name = "COMPANY", length = 100)
    private String company;

    @Column(name = "SEVERITY", length = 50)
    private String severity;

    @Column(name = "ASSIGN_TO", length = 100)
    private String assignTo;

    @Column(name = "GROUP_NAME", length = 100)
    private String groupName;

    // Getters and Setters

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(String assignTime) {
        this.assignTime = assignTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "AutoAssignConfig{" +
                "srNo=" + srNo +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", assignTime='" + assignTime + '\'' +
                ", company='" + company + '\'' +
                ", severity='" + severity + '\'' +
                ", assignTo='" + assignTo + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
