package com.hansen.mobileplan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;

@SpringBootApplication
public class MobilePlanApp {
	
	/*@Bean
	 CommandLineRunner init(MobilePlanSrvc mobilePlanSrvc) {
		
		return (evt) -> {
		
		//create 
		MobilePlan plan = new MobilePlan();
		
		plan.setName("Monthly pack");
		plan.setValidity(28);
		plan.setDescription("2 gb/par day");
		
		mobilePlanSrvc.create(plan);
		
		//update
		plan.setId((long)1);
		plan.setName("half yearly pack");
		plan.setValidity(28);
		plan.setDescription("3 gb/par day");
		
		mobilePlanSrvc.update(plan);
		
		MobilePlan plan2 = new MobilePlan();
		
		plan2.setName("Monthly pack");
		plan2.setValidity(56);
		plan2.setDescription("3 gb/par day");
		
		mobilePlanSrvc.create(plan2);
		
		//delete
		boolean result = mobilePlanSrvc.delete((long)5);
		
		if(result) {
			System.out.println("deleted succesfully!");
		}
		
		Book demoBook = new Book();
		demoBook.setId(1);
		demoBook.setName("Hansen CSD Book");
		demoBook.setAuthor("Satyen Pandhare");
		bookSrvc.createBook(demoBook);
		}
	}
	
	*/

	public static void main(String[] args) {
		SpringApplication.run(MobilePlanApp.class, args);
	}

}
