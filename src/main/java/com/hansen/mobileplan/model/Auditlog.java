package com.hansen.mobileplan.model;

import java.util.Date;

public class Auditlog {
	private Long id;
	private String operationType;
	private String entityJson;
	private Date modificationDate;
	
	
	//Getter-Setters
	
	//Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	//operation type
	public String getOperationType() {
		return operationType;
	}
	
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	//entityJson
	public String getEntityJson() {
		return entityJson;
	}
	
	public void setEntityJson(String entityJson) {
		this.entityJson = entityJson;
	}
	
	//modificationDate
	public Date getModificationDate() {
		return modificationDate;
	}
	
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
}
