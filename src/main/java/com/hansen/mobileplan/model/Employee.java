package com.hansen.mobileplan.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String domain;
	@OneToOne
	private MobilePlan mobilePlan;
	private Date assignedAt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public MobilePlan getMobilePlan() {
		return mobilePlan;
	}
	public void setMobilePlan(MobilePlan mobilePlan) {
		this.mobilePlan = mobilePlan;
	}
	public Date getAssignedAt() {
		return assignedAt;
	}
	public void setAssignedAt(Date assignedAt) {
		this.assignedAt = assignedAt;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", domain=" + domain + ", mobilePlan=" + mobilePlan
				+ ", assignedAt=" + assignedAt + "]";
	}
	
	
	
}
