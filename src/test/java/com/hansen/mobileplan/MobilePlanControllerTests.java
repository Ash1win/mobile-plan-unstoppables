package com.hansen.mobileplan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hansen.mobileplan.ctrlr.MobilePlanController;
import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MobilePlanControllerTests {
	
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	MobilePlanController controller;
	
	@Autowired
	MobilePlanSrvc srvc;
	
	@Test
	@Order(1)
	void testReadAll() {
		
		String url = "http://localhost:8080/mp";
		
		ResponseEntity<MobilePlan[]> allPlans = restTemplate.getForEntity(url, MobilePlan[].class);
		
		assertEquals(HttpStatus.OK, allPlans.getStatusCode() );
		
		System.out.println("Get all Plans Controller Test: Total Records: "+allPlans.getBody().length);
	}
	
	
	
	@Test
	@Order(2)
	void testCreate(){
	
		String url = "http://localhost:8080/mp";
		
		MobilePlan plan = new MobilePlan();
		plan.setName("Entertainment plan");
		plan.setDescription("ZEE 5");
		plan.setValidity(364);
	
		ResponseEntity<MobilePlan> response = restTemplate.postForEntity(url, plan, MobilePlan.class);
		System.out.println("Create Controller Test: "+response.getBody());
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(plan.getName(), response.getBody().getName());
	}
	
	
	@Test
	@Order(3)
	void testReadById() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		MobilePlan lastPlan = list.get(list.size()-1);
		System.out.println("Last Plan: "+lastPlan);
		
		String url = "http://localhost:8080/mp/"+lastPlan.getId();
		
		ResponseEntity<MobilePlan> fetchedPlan = restTemplate.getForEntity(url, MobilePlan.class);
		
		System.out.println("Get By ID Controller Test: Fetched Plan: "+fetchedPlan);
		
		assertEquals(HttpStatus.OK, fetchedPlan.getStatusCode());
		assertEquals(lastPlan.getId(), fetchedPlan.getBody().getId());
	}
	
	
	@Test
	@Order(4)
	void testUpdate() {
		
		String url = "http://localhost:8080/mp";
		
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		MobilePlan lastPlan = list.get(list.size()-1);
		
		lastPlan.setDescription("Dummy Description");
		
		ResponseEntity<MobilePlan> response = restTemplate.postForEntity(url, lastPlan, MobilePlan.class);
		System.out.println("Update Controller Test: "+response.getBody());
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Dummy Description",response.getBody().getDescription());
		
	}
	
	
	@Test
	@Order(5)
	void testDelete() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		MobilePlan lastPlan = list.get(list.size()-1);
		
		String url = "http://localhost:8080/mp/"+lastPlan.getId();
		
		restTemplate.delete(url);
		
		assertNull(srvc.read(lastPlan.getId()));
		
	}


}