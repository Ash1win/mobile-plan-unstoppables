package com.hansen.mobileplan.ctrlr;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.mobileplan.dao.MobilePlanDao;
import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.srvc.MobilePlanSrvc;

@RestController
@RequestMapping("/mp")
public class MobilePlanController {
	private Log logger = LogFactory.getLog(MobilePlanController.class);
	@Autowired
	MobilePlanSrvc mpSrvc;

	@Autowired
	MobilePlanDao mobilePlanDao;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MobilePlan inputentity) {
		logger.info("Inside add method");
		ResponseEntity<Object> mpResponse;
		Object mobilePlan = mpSrvc.create(inputentity);
		if (mobilePlan != null) {
			mpResponse = new ResponseEntity<Object>(mobilePlan, null, HttpStatus.CREATED);
			return mpResponse;
		} else {
			mpResponse = new ResponseEntity<Object>(null, null, HttpStatus.NOT_ACCEPTABLE);
			return mpResponse;
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> read(@PathVariable(value = "id") Long id) {
		logger.info("Inside search method");
		ResponseEntity<Object> mpResponse = null;
		
		//TODO Homework... write the code to read
		
		
		return mpResponse;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<MobilePlan>> readAll() {
		logger.info("Inside readAll method");
		ResponseEntity<Iterable<MobilePlan>> mpResponse = null;

		//TODO Homework... write the code to readall
		
		
		return mpResponse;
	}

	

	@RequestMapping(method = RequestMethod.PATCH) // OR PUT
	public ResponseEntity<Object> update(@RequestBody MobilePlan tobemerged) {
		logger.info("Inside update method");
		ResponseEntity<Object> planResponse = null;
		
		//TODO Homework... write the code to update
		
		
		return planResponse;	
	}

	@RequestMapping(value = "{planid}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable(value = "planid") Long planid) {
		logger.info("Inside delete method");
		ResponseEntity<Object> bookResponse = null;
		
		//TODO Homework... write the code to delete
		
		return bookResponse;
	}

}