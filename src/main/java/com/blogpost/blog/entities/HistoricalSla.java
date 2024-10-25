package com.blogpost.blog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HistoricalSla implements Serializable{

	
	private static final long serialVersionUID = 5890017391363933298L;
	@Id
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_ID;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_START_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_END_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_ELAPSED_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_DURATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getTICKET_ID() {
		return TICKET_ID;
	}

	public void setTICKET_ID(String tICKET_ID) {
		TICKET_ID = tICKET_ID;
	}

	public String getTICKET_STATUS() {
		return TICKET_STATUS;
	}

	public void setTICKET_STATUS(String tICKET_STATUS) {
		TICKET_STATUS = tICKET_STATUS;
	}

	public String getHOLD_START_DATE() {
		return HOLD_START_DATE;
	}

	public void setHOLD_START_DATE(String hOLD_START_DATE) {
		HOLD_START_DATE = hOLD_START_DATE;
	}

	public String getHOLD_END_DATE() {
		return HOLD_END_DATE;
	}

	public void setHOLD_END_DATE(String hOLD_END_DATE) {
		HOLD_END_DATE = hOLD_END_DATE;
	}

	public String getHOLD_ELAPSED_TIME() {
		return HOLD_ELAPSED_TIME;
	}

	public void setHOLD_ELAPSED_TIME(String hOLD_ELAPSED_TIME) {
		HOLD_ELAPSED_TIME = hOLD_ELAPSED_TIME;
	}

	public String getHOLD_DURATION() {
		return HOLD_DURATION;
	}

	public void setHOLD_DURATION(String hOLD_DURATION) {
		HOLD_DURATION = hOLD_DURATION;
	}

	public String getSLA_STATUS() {
		return SLA_STATUS;
	}

	public void setSLA_STATUS(String sLA_STATUS) {
		SLA_STATUS = sLA_STATUS;
	}

	public String getT_COMPANY() {
		return T_COMPANY;
	}

	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}

	public String getT_BRANCH() {
		return T_BRANCH;
	}

	public void setT_BRANCH(String t_BRANCH) {
		T_BRANCH = t_BRANCH;
	}

	public String getT_DEPARTMENT() {
		return T_DEPARTMENT;
	}

	public void setT_DEPARTMENT(String t_DEPARTMENT) {
		T_DEPARTMENT = t_DEPARTMENT;
	}

	@Override
	public String toString() {
		return "HistoricalSla [SR_NO=" + SR_NO + ", TICKET_ID=" + TICKET_ID + ", TICKET_STATUS=" + TICKET_STATUS
				+ ", HOLD_START_DATE=" + HOLD_START_DATE + ", HOLD_END_DATE=" + HOLD_END_DATE + ", HOLD_ELAPSED_TIME="
				+ HOLD_ELAPSED_TIME + ", HOLD_DURATION=" + HOLD_DURATION + ", SLA_STATUS=" + SLA_STATUS + ", T_COMPANY="
				+ T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT + "]";
	}
	
	
	
}
