package com.hansen.mobileplan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;

@SpringBootApplication
public class MobilePlanApp {
	
	@Bean
	CommandLineRunner init(MobilePlanSrvc mobilePlanSrvc) {
		
		return (evt) -> {
			
		MobilePlan plan = new MobilePlan();
		plan.setName("Monthly pack");
		plan.setValidity(28);
		plan.setDescription("2 gb/par day");
		
		mobilePlanSrvc.create(plan);
		
		plan.setId((long)1);
		plan.setName("yearly pack");
		plan.setValidity(28);
		plan.setDescription("1 gb/par day");
		
		mobilePlanSrvc.update(plan);
//		Book demoBook = new Book();
//		demoBook.setId(1);
//		demoBook.setName("Hansen CSD Book");
//		demoBook.setAuthor("Satyen Pandhare");
//		bookSrvc.createBook(demoBook);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MobilePlanApp.class, args);
	}

}
