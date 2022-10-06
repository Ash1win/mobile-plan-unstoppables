package com.hansen.mobileplan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MobilePlanServiceTests {
	
	@Autowired
	MobilePlanSrvc srvc;
	
	//read all
	
	@Test
	@Order(1)
	void testReadAll() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		//make sure the mobile_plan table is not empty
		System.out.println("Total records : "+list.size());
		assertTrue(list.size()>0);
	}
	
	
	//read by ID
	
	@Test
	@Order(2)
	void testReadById() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		long id = list.get(0).getId();
		System.out.println("**** Found first record : "+id+"****");
		assertNotNull(srvc.read(id));
	}
	

	//create
	
	@Test
	@Order(3)
	void testCreate() {
		MobilePlan plan = new MobilePlan();
		plan.setName("Sports Plan");
		plan.setDescription("IPL2023");
		plan.setValidity(364);
		
		MobilePlan createdPlan = (MobilePlan) srvc.create(plan);
		System.out.println("++++++ created : "+createdPlan.getId()+"++++++");
		System.out.println(createdPlan);
		
		assertNotNull(srvc.read(createdPlan.getId()));
	}
	
	
	//update
	
	@Test
	@Order(4)
	void testUpdate() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		MobilePlan lastPlan = list.get(list.size()-1);
		System.out.println("Before Update: "+lastPlan);
		
		String desc = "demo Description";
		lastPlan.setDescription(desc);
		
		MobilePlan updatedPlan = (MobilePlan) srvc.update(lastPlan);
		System.out.println("After Update: "+lastPlan);
		
		assertEquals(desc, updatedPlan.getDescription());
		
	}
	
	//delete
	
	@Test
	@Order(5)
	void testDelete() {
		List<MobilePlan> list = (List<MobilePlan>)srvc.readAll();
		MobilePlan lastPlan = list.get(list.size()-1);
		System.out.println("deleted : "+lastPlan.getId());

		srvc.delete(lastPlan.getId());
		assertNull(srvc.read(lastPlan.getId()));
	}
	
	
}







