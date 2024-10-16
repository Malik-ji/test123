package com.blogpost.blog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data 
@Table(name = "priority_severity_master")
public class PrioritySeverityMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SRNO;  // Assuming SRNO is the primary key

    @Column(name = "company")
    private String Company;

    @Column(name = "priority")
    private String priority;

    @Column(name = "severity")
    private String Severity;

    // Getters, Setters, and toString() method

    @Override
    public String toString() {
        return "PrioritySeverityMaster [SRNO=" + SRNO + ", Company=" + Company + ", Priority=" + priority
                + ", Severity=" + Severity + "]";
    }
}
