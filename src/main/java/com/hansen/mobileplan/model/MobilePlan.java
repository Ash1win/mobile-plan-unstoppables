package com.hansen.mobileplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class MobilePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private int validity;

	//getter-setters
	
	//Id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	//Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//validity
	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}
	
	
	//overriding toString method
	@Override
	public String toString() {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;

		// Converting the Java object into a JSON string
		try {
			jsonStr = Obj.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}

}
