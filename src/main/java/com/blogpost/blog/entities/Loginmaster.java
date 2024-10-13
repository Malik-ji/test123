package com.blogpost.blog.entities;

import java.io.Serializable;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loginmaster implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int SrNo;
	private String username;
	private String Fullname;
	private String Company;
	private String password;
	private String RoleType;
	private String Branch;
	private String Department;
	private String GroupName;
	private String EngineerCategory;
	private String Phone;
	private String Scope;
	private String Location;
	private String Designation;
	private String Email;
	private String SubDepartment;
	
	public int getSrNo() {
		return SrNo;
	}
	public void setSrNo(int srNo) {
		SrNo = srNo;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleType() {
		return RoleType;
	}
	public void setRoleType(String roleType) {
		RoleType = roleType;
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
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getEngineerCategory() {
		return EngineerCategory;
	}
	public void setEngineerCategory(String engineerCategory) {
		EngineerCategory = engineerCategory;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getScope() {
		return Scope;
	}
	public void setScope(String scope) {
		Scope = scope;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSubDepartment() {
		return SubDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		SubDepartment = subDepartment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Loginmaster [SrNo=" + SrNo + ", username=" + username + ", Fullname=" + Fullname + ", Company="
				+ Company + ", password=" + password + ", RoleType=" + RoleType + ", Branch=" + Branch + ", Department="
				+ Department + ", GroupName=" + GroupName + ", EngineerCategory=" + EngineerCategory + ", Phone="
				+ Phone + ", Scope=" + Scope + ", Location=" + Location + ", Designation=" + Designation + ", Email="
				+ Email + ", SubDepartment=" + SubDepartment + "]";
	}
	
	
}
