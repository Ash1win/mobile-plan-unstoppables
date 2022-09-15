package com.hansen.mobileplan.ctrlr;
import java.time.LocalDate;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hansen.mobileplan.dao.MobilePlanDao;
import com.hansen.mobileplan.model.Auditlog;
import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mp")
public class MobilePlanController {
	private Log logger = LogFactory.getLog(MobilePlanController.class);
	
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	MobilePlanSrvc mpSrvc;

	@Autowired
	MobilePlanDao mobilePlanDao;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MobilePlan inputentity) {
		logger.info("Inside Create Method");
		ResponseEntity<Object> mpResponse;
		Object mobilePlan = mpSrvc.create(inputentity);
		if (mobilePlan != null) {
			logger.info("Created Mobileplan Succesfully");
			mpResponse = new ResponseEntity<Object>(mobilePlan, null, HttpStatus.CREATED);
			
			Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("CREATE");
			auditlog.setEntityJson(mpResponse.getBody().toString());
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			
			
			return mpResponse;
		} else {
			logger.error("Mobileplan not created");
			mpResponse = new ResponseEntity<Object>(null, null, HttpStatus.NOT_ACCEPTABLE);
			
			Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("CREATE");
			auditlog.setEntityJson("Mobile Plan Not Created");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			
			return mpResponse;
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> read(@PathVariable(value = "id") Long id) {
		logger.info("Inside Find Method");
		logger.info("Inside search method");
		ResponseEntity<Object> mpResponse = null;
		
		//TODO Homework... write the code to read
		Object MobilePlan = mpSrvc.read(id);
		if(MobilePlan != null) {
			logger.info("Fetched Successfully");
			mpResponse = new ResponseEntity<Object>(MobilePlan, null, HttpStatus.OK);
			
			Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("Get By ID");
			auditlog.setEntityJson(mpResponse.getBody().toString());
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
		}
		else {
			logger.error("Mobileplan Not found");
			mpResponse = new ResponseEntity<Object>(MobilePlan, null, HttpStatus.NOT_FOUND);
			
			Auditlog auditlog = new Auditlog();
			
			//System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("Get By ID");
			auditlog.setEntityJson("Mobile Plan with ID :"+ id +" does not exist.");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
		}
		
		return mpResponse;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<MobilePlan>> readAll() {
		logger.info("Inside show Method");
		logger.info("Mobileplan fetched successfully");
		ResponseEntity<Iterable<MobilePlan>> mpResponse = null;

		//TODO Homework... write the code to readall
		
		Iterable<MobilePlan> mobilePlan = mpSrvc.readAll();
		
		Object MobilePlan = mpSrvc.readAll();
		if(MobilePlan != null) {
			logger.info("Fetched Successfully");
			mpResponse = new ResponseEntity<Iterable<MobilePlan>>(mobilePlan, null, HttpStatus.OK);
			
			Auditlog auditlog = new Auditlog();
			
			
			auditlog.setOperationType("Read_All");
			auditlog.setEntityJson("Read all successfully");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
//			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
		}
		else {
			logger.error("Mobileplan Not found");
			
			Auditlog auditlog = new Auditlog();
			
			
			auditlog.setOperationType("Read_All");
			auditlog.setEntityJson("Read All Unsuccessful");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
//			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			
			mpResponse = new ResponseEntity<Iterable<MobilePlan>>(mobilePlan, null, HttpStatus.NOT_FOUND);
		}
		
		return mpResponse;
		
	}

	

	@RequestMapping(method = RequestMethod.PATCH) // OR PUT
	public ResponseEntity<Object> update(@RequestBody MobilePlan tobemerged) {
		logger.info("Inside Update Method");
		System.out.println(tobemerged);
		ResponseEntity<Object> mpResponse = null;
		
		//TODO Homework... write the code to update
		
		
		boolean MobilePlan= mpSrvc.update(tobemerged);
		
		if(MobilePlan) {
			logger.info("Mobileplan updated successfully");
			mpResponse=new ResponseEntity<>("Updated SucessFully !", null, HttpStatus.CREATED);
			
			Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("UPDATED");
			auditlog.setEntityJson("MobilePlan with id : "+tobemerged.getId()+" updated sucessfully");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			
			
		}else {
			logger.error("Mobileplan does not exist");
			mpResponse=new ResponseEntity<>("ID Not Found Can't Update !", null, HttpStatus.NOT_FOUND);
			
			Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse.getBody().toString());
			
			auditlog.setOperationType("UPDATED");
			auditlog.setEntityJson("MobilePlan with id : "+tobemerged.getId()+" not updated");
			auditlog.setModificationDate(new Date());
			
			//audit
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
		}
		return mpResponse;	
	}

	@RequestMapping(value = "{planid}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "planid") Long planid) {
		logger.info("Inside delete Method");
		logger.info("Inside delete method");
		ResponseEntity<Boolean> mpResponse = null;
		boolean isdelete=mpSrvc.delete(planid);
		if(isdelete) {
			logger.info("Deleted Successfully");
			mpResponse=new ResponseEntity<>(isdelete,null,HttpStatus.OK);
			
            Auditlog auditlog = new Auditlog();
			
			
			
			auditlog.setOperationType("DELETE");
			auditlog.setEntityJson(" Mobileplan with id : "+planid+" Deleted Successfully");
			auditlog.setModificationDate(new Date());
			
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			  
        }
		else {
			logger.error("Can not deleted, ID not found");
			mpResponse=new ResponseEntity<>(isdelete,null,HttpStatus.NOT_FOUND);
			
            Auditlog auditlog = new Auditlog();
			
			System.out.println(mpResponse);
			
			auditlog.setOperationType("DELETE");
			auditlog.setEntityJson( "Mobileplan with id : "+planid+" Not Deleted Successfully");
			auditlog.setModificationDate(new Date());
			
			HttpEntity<Auditlog> req = new HttpEntity<Auditlog>(auditlog);
			restTemplate.postForObject("http://localhost:8081/ac", req, Auditlog.class);
			  

		}
		
		return mpResponse;
	}

}